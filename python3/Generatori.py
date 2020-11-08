n = int(input("Inserire un numero naturale > 1 \n"))

if(n <=1):
    print("Il numero inserito è <= 1")
    exit()
  
def isPrime(n):
    if (n == 1):
        return False
    for i in range(2, int((n**0.5 + 1))):
       if(n % i == 0):
           return False
    else:
            return True
        
    

  

def power( x, y, p):  
  
    res = 1 # Initialize result  
  
    x = x % p # Update x if it is more  
              # than or equal to p  
  
    while (y > 0):  
  
        # If y is odd, multiply x with result  
        if (y & 1): 
            res = (res * x) % p  
  
        # y must be even now  
        y = y >> 1 # y = y/2  
        x = (x * x) % p  
  
    return res  
  
# Utility function to store prime 
# factors of a number  
def findPrimefactors(s, n) : 
  
    # Print the number of 2s that divide n  
    while (n % 2 == 0) : 
        s.add(2)  
        n = n // 2
  
    # n must be odd at this po. So we can   
    # skip one element (Note i = i +2)  
    for i in range(3, int(n**0.5), 2): 
          
        # While i divides n, print i and divide n  
        while (n % i == 0) : 
  
            s.add(i)  
            n = n // i  
          
    # This condition is to handle the case  
    # when n is a prime number greater than 2  
    if (n > 2) : 
        s.add(n)  
  
# Function to find smallest primitive  
# root of n  
def findPrimitive( n) : 
    s = set()  
  
    # Check if n is prime or not  
    if (isPrime(n) == False):  
        return -1
  
    # Find value of Euler Totient function  
    # of n. Since n is a prime number, the  
    # value of Euler Totient function is n-1  
    # as there are n-1 relatively prime numbers. 
    phi = n - 1
  
    # Find prime factors of phi and store in a set  
    findPrimefactors(s, phi)  
  
    # Check for every number from 2 to phi  
    for r in range(2, phi + 1):  
  
        # Iterate through all prime factors of phi.  
        # and check if we found a power with value 1  
        flag = False
        for it in s:  
  
            # Check if r^((phi)/primefactors) 
            # mod n is 1 or not  
            if (power(r, phi // it, n) == 1):  
  
                flag = True
                break
              
        # If there was no power with value 1.  
        if (flag == False): 
            return r  
  
    # If no primitive root found  
    return -1

if(isPrime(n) == False):
    print(str(n) + " non è primo!")
else:
    if(findPrimitive(n) != -1):
        print("Il più piccolo generatore di " + str(n) + " è " + str(findPrimitive(n)))