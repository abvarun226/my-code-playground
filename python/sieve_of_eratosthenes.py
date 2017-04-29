''' Sieve of Eratosthenes '''

import math
import sys


def sieve(num):
    ''' Algorithm to generate list of prime numbers till num '''
    arr = range(0, num + 1)
    for idx in range(2, int(math.sqrt(num)) + 1):
        if arr[idx] != 0:  # idx hasnt been eliminated on previous passes
            j = idx * idx
            while j <= num:
                arr[j] = 0
                j = j + idx
    result = []
    for idx in range(2, num + 1):
        if arr[idx] != 0:
            result.append(arr[idx])
    return result


if __name__ == '__main__':
    N = 25  # default value
    if len(sys.argv) == 2:
        N = int(sys.argv[1])
    print sieve(N)
