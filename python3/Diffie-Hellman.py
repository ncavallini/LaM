#Diffie-Hellman
import random


def isPrime(n):
    if (n == 1):
        return False
    for i in range(2, int((n**0.5 + 1))):
       if(n % i == 0):
           return False
    else:
            return True
        

N = random.randint(2,30)
while(isPrime(N) == False):
    N = random.randint(2,30)

#Array dei generatori di N
g2 = [1]
g3 = [2]
g5 = [2,3]
g7 = [3,5]
g11 = [2,6,7,8]
g13 = [2,6,7,11]
g17 = [3, 5, 6, 7, 10, 11, 12, 14]
g19 = [2, 3, 10, 13, 14, 15]
g23 = [5, 7, 10, 11, 14, 15, 17, 19, 20, 21]
g29 = [2, 3, 8, 10, 11, 14, 15, 18, 19, 21, 26, 27]

gN = []

if(N == 2):
    gN = g2
elif(N == 3):
    gN = g3
elif(N==5):
    gN = g5
elif(N==7):
    gN = g7
elif(N==11):
    gN = g11
elif(N==13):
    gN = g13
elif(N==17):
    gN = g17
elif(N==19):
    gN = g19
elif(N==23):
    gN = g23
elif(N==29):
    gN = g29
else:
    exit()

# Scelta di g
j = random.randint(0, len(gN)-1)
g = gN[j]

#Valori a, b casuali, privati, a,b < N


a = random.randint(2,N)
b = random.randint(2,N)

while(a == b): #Non voglio che a = b
    a = random.randint(2,N)
    b = random.randint(2,N)

#Calcolo di A = g^a (mod N) e B = g^b (mod N)
A = (g**a)%N
B = (g**b)%N

#Calcolo di kA = A^b (mod N) e kB = B^a (mod N), confronto (devono essere uguali)
kA = (A**b)%N
kB = (B**a)%N
if(kA == kB):
    k = kA
else:
    print("Errore generale.")

if(k !=((g**(a*b))%N)):
    print("Errore generale.")
else:
    print("N = " + str(N) + "\t g = " + str(g) + "\t a = " + str(a) + "\t b = " + str(b) + "\t A = " + str(A) + "\t B = " + str(B) + "\n k = " + str(k))
        

