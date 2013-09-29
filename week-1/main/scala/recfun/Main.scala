package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    // base condition
    if (c == 0 || c == r) {
      return 1;
    } else {
      return pascal(c,r-1) + pascal(c-1,r-1);
    }
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    if (chars.isEmpty) return true;
    
    // potato and meat, looks ugly though :)
    // this helper will take a list of char,
    // eliminate non-parentheses characters and
    // matched parentheses. Thus, if anything left,
    // it means the parentheses doesn't match. 
    def helper(chlist: List[Char]): List[Char] = {
      if (chlist.isEmpty) {
        return chlist;
      }
      if (chlist.head == '(') {
        val _tail = helper(chlist.tail);
        if (!_tail.isEmpty && _tail.head == ')'){
          return _tail.tail;
        }
        else {
          return '(' :: _tail; 
        }  
      } 
      else if (chlist.head == ')'){
        return ')' :: helper(chlist.tail);
      }
      else {
        return helper(chlist.tail);
      }
    }
    
    return helper(chars).isEmpty;
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (coins.isEmpty) {
      return 0;
    }
    if (money - coins.head == 0) {
      return 1 + countChange(money, coins.tail);;
    }
    if (money - coins.head < 0) {
      return countChange(money, coins.tail);
    }
    else {
      return countChange(money, coins.tail) + countChange(money-coins.head, coins);
    }
  }
}
