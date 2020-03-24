import time
import pychromecast
from pychromecast.controllers.youtube import YouTubeController


def init():

    chromecasts = pychromecast.get_chromecasts()
    [cc.device.friendly_name for cc in chromecasts]

    cast = next(cc for cc in chromecasts if cc.device.friendly_name == "Dormitorio")
    cast.wait()
    #print(cast.device) # Comprobar que se ha conectado bien
    #print(cast.status) 

    return cast


def playVideo(cast,link):

    mc = cast.media_controller
    mc.play_media(link, 'video/mp4')
    mc.block_until_active()
    mc.play()

#def subirVolumen():




def main() :

    cast =  init()
    yt = YouTubeController()
    cast.register_handler(yt)
    yt.play_video('FX20kcp7j5c')
    
main()