package main

import (
	"fmt"
	"math"
)

// Sieve of eratosthenes
// Algorithm to generate prime numbers till n
func sieve(n int) {
	var arr = make([]int, n+1)
	for i := 0; i <= n; i++ {
		arr[i] = i
	}
	for i := 2; i <= int(math.Sqrt(float64(n))); i++ {
		if arr[i] != 0 {
			j := i * i
			for j <= n {
				arr[j] = 0
				j = j + i
			}
		}
	}
	var res = make([]int, n+1)
	j := 0
	for i := 2; i <= n; i++ {
		if arr[i] != 0 {
			res[j] = arr[i]
			j++
		}
	}
	for _, v := range res {
		if v != 0 {
			fmt.Printf("%d ", v)
		}
	}
	fmt.Println("")
}

func main() {
	sieve(25)
}
