package main

import (
	"fmt"
	"math"
)

func minDistance(arr []int) int {
	dmin := 0
	flag := true
	for i := 0; i < len(arr); i++ {
		for j := 0; j < len(arr); j++ {
			if i != j {
				if flag {
					dmin = int(math.Abs(float64(arr[i] - arr[j])))
					flag = false
				} else if int(math.Abs(float64(arr[i]-arr[j]))) < dmin {
					dmin = int(math.Abs(float64(arr[i] - arr[j])))
				}
			}
		}
	}
	return dmin
}

func main() {
	arr := []int{1, 10, 4, 100, 5}
	result := minDistance(arr)
	fmt.Println("Result is:", result)
}
