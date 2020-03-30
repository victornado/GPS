import sys
import time
import pychromecast


def main():

	requested_volume = float(sys.argv[1]) if len(sys.argv) > 1 else None

	cast = pychromecast.get_chromecast()

	time.sleep(0.5)

	if requested_volume != None:
    	cast.set_volume(requested_volume)
	else:
    	raise Exception('F')
    	
main()