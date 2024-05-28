from PIL import Image
import os
import time
dir_name = "2024-05-28-18.25.09"
os.makedirs(f"./{dir_name}/gifs")
listaLini = []
pixelX = []
pixelY = []
pl = []
size = 200
gen = 120
if os.path.exists(f"./{dir_name}/{gen}.txt"):
    f = open(f"./{dir_name}/{gen}.txt","r")
    Lines = f.readlines()
    for i, line in enumerate(Lines):
        if i>0 and i<len(Lines)-2:
            listaLini.append(line)
            if line != "step\n":
                x,y = line.split(";")
                pixelX.append(int(x))
                pixelY.append(int(y))
    img = Image.new(mode = "RGB", size =(size,size), color=(255,255,255))
    pixels = img.load()
    for k in range(len(pixelY)):
        if listaLini[k] == "step\n":
            if i != 0:
                pl.append(img)
            img = Image.new(mode = "RGB", size =(size,size), color=(255,255,255))
            pixels = img.load()
        if  pixelX[k] > 0 and pixelX[k] < size and pixelY[k] > 0 and pixelY[k] < size: 
            pixels[pixelX[k],pixelY[k]] = (0,0,0)

gif = Image.new('RGB', (size,size))
gif.save(f'./{dir_name}/gifs/{gen}.gif',save_all = True, append_images = pl[0:],optimize = False, duration = 10)



