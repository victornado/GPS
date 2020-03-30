import time
import pychromecast
from pychromecast.controllers.youtube import YouTubeController


def init():

    activo = False
    cast = None
    chromecasts = pychromecast.get_chromecasts()
    [cc.device.friendly_name for cc in chromecasts]

    if len(chromecasts) != 0 :
        print('AA')
        cast = next(cc for cc in chromecasts if cc.device.friendly_name == "Dormitorio")
        cast.wait()
        activo = True
    

    #print(cast.device) # Comprobar que se ha conectado bien
    #print(cast.status) 

    return cast, activo


def playVideo(cast,link):

    mc = cast.media_controller
    mc.play_media(link, 'video/mp4')
    mc.block_until_active()
    mc.play()


def main() :

    cast, activ =  init()

    if cast != None and activ == True :
        yt = YouTubeController()
        cast.register_handler(yt)
        yt.play_video('kLpH1nSLJSs')
        #print('ok')
    else :
        raise Exception('F')
    
main()