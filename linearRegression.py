import matplotlib.pyplot as plt
import numpy as np
from sklearn.datasets import load_diabetes
from sklearn import linear_model

fig = plt.figure() #Create a fugure to display graphs
d = load_diabetes() #Load the dataset
d_X = d.data[: , np.newaxis,2] # #Load the data from d.data[2]
dx_train = d_X[: -20] #Create training data (All elemets except last 20)
dy_train = d.target[: -20,np.newaxis] #Create training targets
dx_test = d_X[-20:] #Create test data (the last 20 elements)
dy_test = d.target[-20:] #Create test targets

ax3 = plt.subplot(1,1,1)

#Define a function to return y as per the task outline
def myFormula(xtest, ytest):
    m = ((np.mean(xtest)*np.mean(ytest)) - np.mean(xtest*ytest)) / ((np.mean(xtest))**2 - np.mean(xtest**2))
    b = np.mean(ytest) - m*np.mean(xtest)
    y = (m*xtest) + b
    return y;
    
#Create scatter points on graph 3
ax3.scatter(dx_test, dy_test, label = 'Line Graph')
ax3.scatter(dx_train, dy_train, c='r', label = 'Training Data')
ax3.plot(dx_train, myFormula(dx_train, dy_train), c = 'b', label = "Testing Data")
ax3.legend(loc = 'upper left')

plt.show()
