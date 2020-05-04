#<20ms
class Solution:
    def findComplement(self, num: int) -> int:
		#calculate number of bits
        length = int(math.log2(num)) + 1
        for i in range(length):
            num = (num ^ (1 << i)) #<< implies a left shift, followed by XOR operation 
        return num