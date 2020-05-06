import tensorflow as tf 
import numpy as np 
import cv2 
import api
import os
from datetime import datetime

class Videoreid:
    
    
    past_ppl_vector= []
  
    def __init__(self):  
        self.current_img_vector = []
        
    def video_reid(self,path):
        
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
        past_ppl='../Identity_Gallery/3person'
        while(videoOn):
            ret, frame=cap.read()
            if(ret == False):
                break    
            arr=[]
            img_location = api.human_locations(frame)
            img_human = api.crop_human(frame, img_location)
            for j in range(len(img_human)):
                arr.append(self.find(img_human[j],past_ppl))
            frame=self.draw_boxes(frame,img_location,arr) 
            cv2.imshow('Video', frame)
            if cv2.waitKey(1) & 0xFF == ord('q'):
                break
            out.write(frame)
        cap.release()
        out.release()
        cv2.destroyAllWindows()
        print('end') 
        return 'F://Output_Videos//'+filename+'.webm'
    
    def draw_boxes(self,frame,img_location,arr):
        for i in range(len(img_location)):
            xLeftBottom = img_location[i][0][0]
            yLeftBottom = img_location[i][0][1]
            xRightTop   = img_location[i][1][0]
            yRightTop   = img_location[i][1][1]        
            frame=cv2.rectangle(frame,(xLeftBottom,yLeftBottom),(xRightTop,yRightTop),(0,0,255),2)        
            frame=cv2.putText(frame, str(arr[i]), (xRightTop,yLeftBottom),cv2.FONT_HERSHEY_TRIPLEX, 2, (0,0,255), 2, cv2.LINE_AA) 
        return frame
    
    def find(self,img,past_ppl):
        maxp=0
        fd=1
        current_img_vector=api.human_vector(img)
        folders = os.listdir(past_ppl)
        
        for folder in folders:   
            same = 0
            diff = 0
          
            files = os.listdir(past_ppl + '/' + folder)
            file=-1
            for f in files:
                file+=1
                #print(f)
                #print(folder)
                #print(Videoreid.past_ppl_vector)
                #print(int(folder))
                #print(file)
                file_vector=Videoreid.past_ppl_vector[int(folder)-1][file]
                distance=api.human_distance(current_img_vector, file_vector)
                if(distance < 20):
                    same=+1
                else:
                    diff=+1
            p = 100 * float(same) / float(same + diff)  
            if( maxp < p ):
                maxp=p
                fd=folder
        
        if(maxp > 90):
            files = os.listdir(past_ppl + '/' + fd)
            person_no = len(files) + 1
            cv2.imwrite(past_ppl + '/' + fd + '/' + str(person_no) + '.jpg',img)  
            print('old person detected at '+str(fd)+' '+ str(datetime.now().time()))
            current_folder=Videoreid.past_ppl_vector[int(fd)-1]
            current_folder.append(current_img_vector)
            Videoreid.past_ppl_vector[int(fd)-1]=current_folder
            return int(fd)
        
        else:
            l = len(folders)+1
            print('new person detected at '+str(l)+' '+ str(datetime.now().time()))
            os.makedirs(past_ppl + '/' + str( l )  )
            cv2.imwrite(past_ppl + '/' + str( l ) + '/1.jpg',img)
            folder_vector=[]
            folder_vector.append(current_img_vector)
            Videoreid.past_ppl_vector.append(folder_vector)
            #print(Videoreid.past_ppl_vector)
            return l
        
        
    def vector_empty(self):
        Videoreid.past_ppl_vector=[]
        

    def print_vector(self):
        print(Videoreid.past_ppl_vector)
        
        
        