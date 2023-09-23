import numpy as np
import matplotlib.pyplot as plt

def create_data():
	'''
	This function creates data for plotting
	'''
	
	x : np.ndarray = np.array([i * 15 for i in np.arange(0, 7)])
	
	y_sin : np.ndarray = np.array([np.sin((np.pi * i * 15) / 180) for i in np.arange(0, 7)])
	y_cos : np.ndarray = np.array([np.cos((np.pi * i * 15) / 180) for i in np.arange(0, 7)])
	
	#y_tan : np.ndarray = np.array([np.tan((np.pi * i * 15) / 180) for i in np.arange(0, 7)])
	#y_cosec : np.ndarray = np.array([1 / np.sin((np.pi * i * 15) / 180) for i in np.arange(0, 7)])
	#y_sec : np.ndarray = np.array([1 / np.cos((np.pi * i * 15) / 180) for i in np.arange(0, 7)])
	#y_cot : np.ndarray = np.array([1 / np.sin((np.pi * i * 15) / 180) for i in np.arange(0, 7)])
	
	return np.reshape(np.concatenate([np.concatenate([x, y_sin], 0), y_cos], 0), [3, -1])

def plot(data : np.ndarray):
	'''
	This function plots the data
	'''
	
	plt.plot(data[0], data[1], "--*", label = "Sine")
	plt.plot(data[0], data[2], "--*", label = "Cosine")
	
	#plt.plot(x, y_tan, "--*", label = "Tangent")
	#plt.plot(x, y_cosec, "--*", label = "Cosecant")
	#plt.plot(x, y_sec, "--*", label = "Secant")
	#plt.plot(x, y_cot, "--*", label = "Cotangent")
	
	plt.title("Values Of Trigonometric Functions!", fontsize = 15)
	plt.xlabel("Degrees(°)")
	plt.ylabel("Values")
	plt.legend()

def make_visible():
	'''
	This function displays the graph
	'''
	
	plt.show()
	
plot(create_data())
make_visible()
