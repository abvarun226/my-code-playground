package main

import (
	"fmt"
	"math"
)

func binaryToDecimal(binary string) {
	var result int64
	result = 0
	binLength := len(binary)
	j := 0
	for i := binLength - 1; i >= 0; i-- {
		result = result + (int64(math.Pow(float64(2), float64(i))) * (int64(binary[j]) - 48))
		j++
	}
	fmt.Println("Decimal is:", result)
}

func main() {
	binary := "1111010101"
	binaryToDecimal(binary)
}
