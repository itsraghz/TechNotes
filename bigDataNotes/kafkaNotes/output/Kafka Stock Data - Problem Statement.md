# Kafka Stock Data - Problem Statement

## Data and Problem Statement

### Stock Data Analysis

Predicting the stock market is, without a doubt, one of the most challenging tasks in the finance industry. It is difficult to keep track of the market as many variables play an essential role in controlling it. 

Stock data analysis is used by investors and traders to make critical decisions related to the stocks. Investors and traders study and evaluate past and current stock data and attempt to gain an edge in the market by making decisions based on the insights obtained through the analyses.

Suppose you are working in an angel broking company. You have been provided real-time global equity data. The data contains the following information:

    * symbol - id of the stock
    * timestamp - time at which we are getting the data
    * open - the price at which the particular stock opens in the time period
    * high - highest price of the stock during the time period
    * low - lowest price of the stock during the time period
    * close - the price at which the particular stock closes in the time period
    * volume - indicates the total number of transactions involving the given stock in the time period

Based on the data, you need to perform some real-time analyses to generate insights that can be used to make informed decisions.

### How to get the data? 

We have hosted a centralized Kafka server for this project.  Following are the details of the centralized Kafka server- 

```
Broker ID: 52.55.237.11
Topic Name: stockData
```
Apart from these two parameters you also need to mention a Kafka consumer group ID, this value can be anything you like, but make sure you use a unique one each time you run your program.

In our Kafka server, we are getting real-time data for the 4 cryptocurrencies,  BTC (Bitcoin), ETH (Ethereum), LTC (Litecoin) and XRP using a JAVA API of [CryptoCompare](https://www.cryptocompare.com/). This API fetches the data for these 4 cryptocurrencies every minute and writes it into the above mentioned Kafka topic.

To get this real-time data into your Spark Streaming application you need to subscribe to the  Kafka topic and create a DStream. The data that you will consume from the Kafka topic will be in JSON format. One batch of the raw data consumed from the Kafka topic is shown below. You need to set your batch interval as 1 minute. 

```
{"symbol":"BTC","timestamp":"2019-05-14 09:43:00","priceData":{"close":8063.07,"high":8063.32,"low":8048.36,"open":8052.58,"volume":-983281.62}}
{"symbol":"ETH","timestamp":"2019-05-14 09:43:00","priceData":{"close":207.08,"high":207.09,"low":206.71,"open":206.81,"volume":-185453.06}}
{"symbol":"LTC","timestamp":"2019-05-14 09:43:00","priceData":{"close":90.39,"high":90.39,"low":90.23,"open":90.23,"volume":-6370.7300000000005}}
{"symbol":"XRP","timestamp":"2019-05-14 09:43:00","priceData":{"close":0.376,"high":0.3767,"low":0.3758,"open":0.3759,"volume":58695.060000000005}}
```

*Note:* The volume for certain cryptocurrencies is negative, Please take the absolute value of it before doing any calculation involving it. 

As you can see the input data is in JSON format and you need to properly parse it into Java objects. You can refer to the segment Resources-01 (in the next session) for your reference. 

### Problem Statement

Once you subscribe to the Kafka topic you should get a stream of the data you need to apply appropriate transformations on the Dstream to perform the below-mentioned analysis. The results of the analyses should be written in an output file. These results will act as insights to make informed decisions related to the stocks.

Let's now look into the specifics of the problem statement:

    Fetch data every minute relating to the following four cryptocurrencies from the Kafka topic. 
        BTC (Bitcoin)
        ETH (Ethereum)
        LTC (Litecoin)
        XRP
    Parse the data into Java objects, refer to the segment, Resouces-01 in the next session.

1. Calculate the simple moving average closing price of the four stocks in a 5-minute sliding window for the last 10 minutes.  Closing prices are used mostly by the traders and investors as it reflects the price at which the market finally settles down. The SMA (Simple Moving Average) is a parameter used to find the average stock price over a certain period based on a set of parameters. The simple moving average is calculated by adding a stock's prices over a certain period and dividing the sum by the total number of periods. The simple moving average can be used to identify buying and selling opportunities

 

2. Find the stock out of the four stocks giving maximum profit (average closing price - average opening price) in a 5-minute sliding window for the last 10 minutes. 

 

3. Calculate the trading volume(total traded volume) of the four stocks every 10 minutes and decide which stock to purchase out of the four stocks. Remember to take the absolute value of the volume. Volume plays a very important role in technical analysis as it helps us to confirm trends and patterns. You can think of volumes as a means to gain insights into how other participants perceive the market. Volumes are an indicator of how many stocks are bought and sold over a given period of time. Higher the volume, more likely the stock will be bought. 

 

 

Note: The entire project can be done on the local(from Eclipse). EC2 or VM is not mandatory.

 

======================================================================

Note: The below problem statement is optional for you, it is added as a practice problem and doesn't have any weightage for the project. 

 

 [Optional]Find out the Relative Strength Index or RSI of the four stocks in a 1-minute sliding window for the last 10 minutes. RSI is considered overbought when above 70 and oversold when below 30. The formula to calculate the RSI is as follows:
RSI

To simplify the calculation explanation, RSI has been broken down into its basic components: RS, Average Gain and Average Loss. This RSI calculation is based on 14 periods, which is the default suggested by Wilder in his book. Losses are expressed as positive values, not negative values.

 

The very first calculations for average gain and average loss are simple 14-period averages.

 

First Average Gain = Sum of Gains over the past 14 periods / 14.
First Average Loss = Sum of Losses over the past 14 periods / 14


The second, and subsequent, calculations are based on the prior averages and the current gain loss:

Average Gain = [(previous Average Gain) x 13 + current Gain] / 14.
Average Loss = [(previous Average Loss) x 13 + current Loss] / 14.


Taking the prior value plus the current value is a smoothing technique similar to that used in calculating an exponential moving average. Here, in our case, we will use 10-period averages


## References

	* https://zerodha.com/
	* https://www.investopedia.com/