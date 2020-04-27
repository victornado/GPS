import sys
import time
import pychromecast



def main():

    activo = False
    cast = None
    chromecasts = pychromecast.get_chromecasts()
    [cc.device.friendly_name for cc in chromecasts]

    if len(chromecasts) != 0 :
        print('AA')
        cast = next(cc for cc in chromecasts if cc.device.friendly_name == "Dormitorio")
        cast.wait()
        activo = True

    requested_volume = float(sys.argv[1]) if len(sys.argv) > 1 else None
    time.sleep(0.5)

    if requested_volume != None:
        cast.set_volume(requested_volume)
    else:
        raise Exception('F')
    
main()