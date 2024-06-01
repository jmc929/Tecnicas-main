import os

# Define la ruta a la carpeta con las imágenes .png
ruta_carpeta = './'

# Obtiene una lista de todos los archivos en la carpeta que terminan en .png
archivos_png = [archivo for archivo in os.listdir(ruta_carpeta) if archivo.endswith('.png')]

# Renombra cada archivo enumerándolos en orden secuencial
for indice, archivo in enumerate(archivos_png, start=1):
    nuevo_nombre = f"imagen_{indice}.png"
    os.rename(os.path.join(ruta_carpeta, archivo), os.path.join(ruta_carpeta, nuevo_nombre))

print("Renombrado de archivos completado.")
