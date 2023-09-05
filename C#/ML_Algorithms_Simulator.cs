using System;

namespace Algorithms
{
    public class MainClass
    {
        public static void Main(string[] args)
        {
            /* NEURAL NETWORK
            
            NeuralNetwork neuralNetwork = new NeuralNetwork(5, 3, 5);
            double[] inputLayer = {2.5, 7.1, 8.9, 11.0, 0};
            double[] target = {5.0, 14.1, 17.8, 22.0, 0};
            double learningRate = 0.1;
            int numberOfEpochs = 100;
            
            for(int epoch = 0; epoch < numberOfEpochs; epoch++)
                neuralNetwork.Train(inputLayer, target, learningRate);
            
            double[] input = {1, 1, 1, 1, 1};
            double[] outputLayer = neuralNetwork.Predict(input);
            
            foreach(double output in outputLayer)
                Console.WriteLine(output);
            */
        }
    }
    
    public class NeuralNetwork
    {
        private int InputSize;
        private int HiddenSize;
        private int OutputSize;
        
        private double[] HiddenLayer;
        private double[] OutputLayer;
        
        private double[,] WeightsInputToHidden;
        private double[,] WeightsHiddenToOutput;
        
        private Random random = new Random();
        
        public NeuralNetwork(int inputSize, int hiddenSize, int outputSize)
        {
            InputSize = inputSize;
            HiddenSize = hiddenSize;
            OutputSize = outputSize;
            
            HiddenLayer = new double[HiddenSize];
            OutputLayer = new double[OutputSize];
            
            WeightsInputToHidden = new double[InputSize, HiddenSize];
            WeightsHiddenToOutput = new double[HiddenSize, OutputSize];
            
            for(int i = 0;i < InputSize;i++)
            {
                for(int j = 0;j < HiddenSize;j++)
                    WeightsInputToHidden[i ,j] = random.NextDouble();
            }
            
            for(int i = 0;i < HiddenSize;i++)
            {
                for(int j = 0;j < OutputSize;j++)
                    WeightsHiddenToOutput[i ,j] = random.NextDouble();
            }
        }
        
        public double[] FeedForward(double[] InputLayer)
        {
            if(InputLayer.Length != InputSize)
                throw new ArgumentException("InputLayer size does not match the InputSize of the neural network.");
            
            for(int i = 0;i < HiddenSize;i++)
            {
                double sum = 0;
                for(int j = 0;j < InputSize;j++)
                    sum += InputLayer[j] * WeightsInputToHidden[j, i];
                HiddenLayer[i] = Sigmoid(sum);
            }
            
            for(int i = 0;i < OutputSize;i++)
            {
                double sum = 0;
                for(int j = 0;j < HiddenSize;j++)
                    sum += HiddenLayer[j] * WeightsHiddenToOutput[j, i];
                OutputLayer[i] = Sigmoid(sum);
            }
            
            return OutputLayer;
        }
        
        public double Sigmoid(double x)
        {
            return 1.0 / (1.0 + Math.Exp(-x));
        }
        
        public void Train(double[] InputLayer, double[] target, double learningRate)
        {
            FeedForward(InputLayer);
            
            double[] outputErrors = new double[OutputSize];
            for (int i = 0; i < OutputSize; i++)
                outputErrors[i] = target[i] - OutputLayer[i];
            
            double[] hiddenErrors = new double[HiddenSize];
            for (int i = 0; i < HiddenSize; i++)
            {
                double errorSum = 0;
                for (int j = 0; j < OutputSize; j++)
                    errorSum += outputErrors[j] * WeightsHiddenToOutput[i, j];
                hiddenErrors[i] = HiddenLayer[i] * (1 - HiddenLayer[i]) * errorSum; 
            }
            
            for(int i = 0; i < HiddenSize; i++)
            {
                for(int j = 0; j < OutputSize; j++)
                    WeightsHiddenToOutput[i, j] += learningRate * outputErrors[j] * HiddenLayer[i];
            }
            
            for(int i = 0; i < InputSize; i++)
            {
                for(int j = 0; j < HiddenSize; j++)
                    WeightsInputToHidden[i, j] += learningRate * hiddenErrors[j] * InputLayer[i];
            }
        }
        
        public double[] Predict(double[] input)
        {
            return FeedForward(input);
        }
    }
}
