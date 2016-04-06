#Import the necessary methods from tweepy library
from tweepy.streaming import StreamListener
from tweepy import OAuthHandler
from tweepy import Stream

#Variables that contains the user credentials to access Twitter API 
access_number = "136895952-4gOLa18nHJfqAMovCETZGQAtbtt7CzDty6eXwOeX"
access_number_sec = "S7R72kLNjs7HdUMjvA4ThMEmz21dAhOPB1rFGqFtHNgOI"
my_key = "nlnuMkd5AFe7WKrdnqFoNH6Qm"
my_secret = "ozz3x536FnmpAHuBIYi7DwJgwvLNuSreQPaGYLudXgoAnw7oqB"


#This is a basic listener that just prints received tweets to stdout.
class StdOutListener(StreamListener):

    def on_data(self, data):
        print (data)
        return True

    def on_error(self, status):
        print (status)


if __name__ == '__main__':

    #This handles Twitter authentication and the connection to Twitter Streaming API
    l = StdOutListener()
    authorization = OAuthHandler(my_key, my_secret)
    authorization.set_access_token(access_number, access_number_sec)
    stream = Stream(authorization, l)

    #This line filter Twitter Streams to capture data by the keywords: 'python', 'javascript', 'ruby'
    stream.filter(track=['PepsiIPL'])