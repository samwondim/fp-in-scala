trait List[+A]
case object Nil extends List[Nothing]
case class Cons[A](head: List[A], tail: List[A]) extends List[A]

object List {
    def sum(ints: List[A]): Int = ints match 
        case Nil => 0
        case Cons(x, xs) => x + sum(xs)

    def product(ds: List[Double]): Double = ds match
        case Nil => 1.0
        case Cons(0.0, _) => 0.0
        case Cons(x, xs) => x * product(xs)

    def apply[A](as: A*): List[A] =
        if(as.isEmpty) Nil
        else Cons(as.head, apply(as.tail: _*))
    
    def tail[A](l: List[A]): List[A] = l match 
        case Nil => System.err("empty list")
        case Cons(_, x) => x 

    def setHead[A](data: A, l: List[A]): List[A] = l match
        case Nil => System.err("empty list")
        case Cons(_, t) => Cons(data, t)

    def drop[A](n: Int, l: List[A]): List[A] = l 
        if(n <= 0) l else l match
            case Nil => Nil 
            case Cons(_, t) => drop(n - 1, t)
    
    def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match 
        case Cons(h, t) if f(h) => dropWhile(t, f)
        case _ => l
    
    def init[A](l: List[A]): List[A] = l match 
        case Nil => System.err("empty list")
        case Cons(_, Nil) => _ 
        case Cons(h, t) => Cons(h, init(t))
        
}
end List


