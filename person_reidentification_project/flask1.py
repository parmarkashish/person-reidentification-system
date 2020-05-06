from flask import Flask, jsonify, request 
from flask_cors import CORS, cross_origin
import reid3

app = Flask(__name__) 
cors = CORS(app) 
app.config['CORS_HEADERS'] = 'Content-Type'
@app.route('/reid/', methods = ['GET', 'POST']) 
@cross_origin()
def reid(): 
    if(request.method == 'GET'): 
      videopath = request.args.get('videopath')
      print('started')
      object=reid3.Videoreid()
      return object.video_reid(videopath)
      
        


        
if __name__ == '__main__': 
  
    app.run(debug = True) 
    
    
    
    
    '''if(request.method == 'POST'):
        data = "hello post"
        return jsonify({'data': data}) '''
    