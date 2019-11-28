import cv2
import numpy as np
from imutils.video import WebcamVideoStream
import imutils
import subprocess
MIN_MATCH_COUNT=20
count = 0

detector=cv2.SIFT()

FLANN_INDEX_KDITREE=0
flannParam=dict(algorithm=FLANN_INDEX_KDITREE,tree=5)
flann=cv2.FlannBasedMatcher(flannParam,{})

trainImg=cv2.imread("TrainingData/pic.png",0)
trainKP,trainDesc=detector.detectAndCompute(trainImg,None)

vs = WebcamVideoStream(src=0).start()

while True:
	frame = vs.read()
	frame = imutils.resize(frame, width=600)

	key = cv2.waitKey(1) & 0xFF
	ret = frame 
	QueryImgBGR=frame
	# check to see if the frame should be displayed to our screen
	QueryImg=cv2.cvtColor(QueryImgBGR,cv2.COLOR_BGR2GRAY)
	queryKP,queryDesc=detector.detectAndCompute(QueryImg,None)
	matches=flann.knnMatch(queryDesc,trainDesc,k=2)

	goodMatch=[]
	for m,n in matches:
		if(m.distance<0.75*n.distance):
			goodMatch.append(m)
	if(len(goodMatch)>MIN_MATCH_COUNT):
		tp=[]
		qp=[]
		for m in goodMatch:
			tp.append(trainKP[m.trainIdx].pt)
			qp.append(queryKP[m.queryIdx].pt)
		tp,qp=np.float32((tp,qp))
		H,status=cv2.findHomography(tp,qp,cv2.RANSAC,3.0)
		h,w=trainImg.shape
		trainBorder=np.float32([[[0,0],[0,h-1],[w-1,h-1],[w-1,0]]])
		queryBorder=cv2.perspectiveTransform(trainBorder,H)
		cv2.polylines(QueryImgBGR,[np.int32(queryBorder)],True,(0,255,0),5)
                count = count + 1
                if(count == 7):
                        subprocess.call(['java', '-jar', 'FinalOutput.jar'])
                        raise SystemExit(0)
		print "hiii"
	else:
                count =-1 
		print "Not Enough match found- %d/%d"%(len(goodMatch),MIN_MATCH_COUNT)
	cv2.imshow('result',QueryImgBGR)
	if cv2.waitKey(10)==ord('q'):
		break
cam.release()
cv2.destroyAllWindows()
vs.stop()
