import tensorflow as tf 
import numpy as np 
import cv2 
import api
import os
from datetime import datetime

def video_reid(path):
    arr=[]
    cap=cv2.VideoCapture(path)
    frame_height=int(cap.get(4))
    frame_width=int(cap.get(3))
    fps=int(cap.get(5))
    fourcc=cv2.VideoWriter_fourcc(*'VP80')
    base=os.path.basename(path)
    filename=os.path.splitext(base)[0]
    out=cv2.VideoWriter('../Output_Videos/'+filename+'.webm',fourcc,fps,(frame_width,frame_height))
    videoOn=True
    past_ppl='../Identity_Gallery/final'
    while(videoOn):
        
        ret, frame=cap.read()
        if(ret == False):
            break    
        arr=[]
        img_location = api.human_locations(frame)
        img_human = api.crop_human(frame, img_location)
        for j in range(len(img_human)):
            arr.append(find(img_human[j],past_ppl))            
        frame=draw_boxes(frame,img_location,arr) 
        out.write(frame)
    cap.release()
    out.release()
    print('end') 
    return 'F://Output_Videos//'+filename+'.webm'

def draw_boxes(frame,img_location,arr):
    for i in range(len(img_location)):
        xLeftBottom = img_location[i][0][0]
        yLeftBottom = img_location[i][0][1]
        xRightTop   = img_location[i][1][0]
        yRightTop   = img_location[i][1][1]        
        frame=cv2.rectangle(frame,(xLeftBottom,yLeftBottom),(xRightTop,yRightTop),(0,0,255),2)        
        frame=cv2.putText(frame, str(arr[i]), (xRightTop,yLeftBottom),cv2.FONT_HERSHEY_TRIPLEX, 2, (0,0,255), 2, cv2.LINE_AA) 
    return frame

def image_reid(path):
    arr=[]
    img = cv2.imread(path)
    img_location = api.human_locations(img)
    img_human = api.crop_human(img, img_location) 
    for j in range(len(img_human)):
        folder_number=find(img_human[j]);
        print(folder_number)
        arr.append(folder_number)            
    cv2.imshow('frame',draw_boxes(img,img_location,arr))
    cv2.waitKey(0)
    
def find(img,past_ppl):
        maxp=0
        fd=1
        cv2.imwrite('./temporaryImg.jpg',img)
        folders = os.listdir(past_ppl)
        for folder in folders:   
            same = 0
            diff = 0
            i=-1
            files = os.listdir(past_ppl + '/' + folder)
            for f in files:
                i=i+1
                if(i%5 != 0):
                    continue
                ret = compare('./temporaryImg.jpg' , './'+past_ppl+'/'+folder+'/'+f)
                if(ret == True):
                    same += 1
                else:
                    diff += 1  
            p = 100 * float(same) / float(same + diff)  
            #print(str(p))
            if( maxp < p ):
                maxp=p
                fd=folder
        
        if(maxp > 80):
            files = os.listdir(past_ppl + '/' + fd)
            person_no = len(files) + 1
            cv2.imwrite(past_ppl + '/' + fd + '/' + str(person_no) + '.jpg',img)  
            print('old person detected at '+str(fd)+' '+ str(datetime.now().time()))
            return int(fd)
        
        else:
            l = len(folders)+1
            print('new person detected at '+str(l)+' '+ str(datetime.now().time()))
            os.makedirs(past_ppl + '/' + str( l )  )
            cv2.imwrite(past_ppl + '/' + str( l ) + '/1.jpg',img)
            return l
       

    
    
def compare(path1, path2):
    img1 = cv2.imread(path1)[:,:,::-1]
    img2 = cv2.imread(path2)[:,:,::-1]
    human_1_vector = api.human_vector(img1)
    human_2_vector = api.human_vector(img2)
    #print(api.human_distance(human_1_vector, human_2_vector))
    if(api.human_distance(human_1_vector, human_2_vector) < 15):
        return True
    else:
        return False
    