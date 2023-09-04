using System;

namespace Algorithms
{
    public class MainClass
    {
        public static void Main(string[] args)
        {
            NeuralNetwork neuralNetwork = new NeuralNetwork(2, 3, 1);
            double[] inputLayer = {0.5, 0.7};
            double[] outputLayer = neuralNetwork.FeedForward(inputLayer);
            
            foreach(double output in outputLayer)
                Console.WriteLine(output);
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
    }
}
