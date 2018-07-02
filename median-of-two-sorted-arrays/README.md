---
categories: algorithms
tags:
 - Java
 - Difficulty-hard 
---

## Description
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

두 개의 정렬된 배열에서 중앙인 값을 찾아라.

통계학에서의 중앙값(median) 또는 중위수는 어떤 주어진 값들을 크기의 순서대로 정렬했을 때 가장 중앙에 위치하는 값을 의미한다.
예를 들면 1,2,100 인 경우 1~100의 중앙인 50이 아닌 배열의 중앙인 2가 중앙값이 된다.
짝수인 경우는 중앙의 두 값의 평균을 취해서 중앙값을 도출한다.

즉, 표본에 극단적인 값의 차이가 있을 경우 전체의 산술적인 평균값보다 중앙값이 통계적으로 유용하다.


이에 따라 아래가 성립한다.

    len(left_part) = len(right_part)
    max(left_part) ≤ min(right_part)
    
    median = (max(left_part) + min(right_part)) / 2


## Write a function:

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {        
        }
    }

---
## Example :

    nums1 = [1, 3]
    nums2 = [2]

    The median is 2.0
    
    --
            
    nums1 = [1, 2]
    nums2 = [3, 4]
    
    The median is (2 + 3)/2 = 2.5


## Assume that


## Complexity

- 
- 

## Real world examples


## Credits

