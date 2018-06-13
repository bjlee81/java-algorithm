---
categories: algorithms
tags:
 - Java
 - Difficulty-medium 
---

## Description
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

두 개의 양의 정수를 나타내는 두개의 비어있지 않은 링크드 리스트가 제공된다.
숫자는 역순으로 저장되고 각 노드에는 하나의 숫자가 포함된다.
두 숫자를 더하고 링크드 리스트로 반환해라.

두 숫자에 숫자 0을 제외한 선행하는 0이 없다고 가정할 수 있습니다.

- 각 링크의 숫자들을 더하는 것 이기에 각 링크별로 10 이 넘어가면 다음 링크로 넘길 수 있는 carry 가 필요.
- single digit 이기에 carry 는 bool 형이면 충분. carry 가 true이면 다음 링크에 +1

  

---
#
### Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)

Output: 7 -> 0 -> 8

Explanation: 342 + 465 = 807.

## Real world examples


## Credits

