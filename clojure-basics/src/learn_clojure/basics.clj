(ns learn-clojure.basics)

;;
;; ## Clojure basics
;;
;; I will try to introduce concepts gradually without assuming prior
;; knowledge of Clojure (or any other LISP dialect).  However I will
;; assume that you are already an experienced developer in any other
;; popular language such as Java, C/C++, Python or Javascript.
;; General programming concepts such as functions, parameters,
;; recursion, objects and common data-structures such as: linked
;; lists, maps (or dictionaries), vectors and sets will be assumed to
;; be already known.
;;
;;
;;
;; ### The function call.
;;
;; The first concept I will introduce is how to make a function call.
;; We will see more about functions later, but for the moment
;; I want to make sure that you will understand the next few examples.
;; Let's start to make some comparisons with method or function
;; calls in a few different languages
;;
;;     // java and C++
;;     myObject.myFunction(arg1, arg2, arg3);
;;
;;     // C
;;     myFunction(myStruct, arg1, arg2, arg3);
;;
;;     ;; Clojure
;;     (my-function myObject arg1 arg2 arg3)
;;
;;
;; As you can see in Clojure the brackets surround the function and
;; all its arguments.  In object oriented languages such as Java and
;; C++ the object comes before the method name or function name. In C
;; and Clojure the function comes first, then followed by the target
;; object. Let's see a concrete example, _for the sake of the example
;; I will omit the required package imports._
;;
;;
;;     // java
;;     "Hello World!".toLowerCase();
;;
;;     // C - single char
;;     tolower(*c);
;;     // C - Whole string
;;     for ( ; *c; ++c) *c = tolower(*c);
;;
;;     ;; Clojure
;;     (lower-case "Hello World!")
;;
;;
;; _NOTE: In the standard C library there is only a function to turn a
;; single character into its lowercase form, that's why there is a
;; loop._
;;
;; However in the `tolower(*c)` we can see the function comes first
;; followed by its arguments surrounded by bracket.  In Clojure, the
;; expression (called `s-expr`) starts with an open bracket,
;; followed by a function followed by a list of arguments.
;;
;; The following code is designed to run in the Clojure REPL, the
;; conventions I will follow throughout the text is to display the
;; result of the expression evaluation prefixed with this evaluation
;; marker `;;=>`. So every time you'll see a Clojure expression
;; followed by `;;=>` and followed by another value it means that the
;; result of the evaluation of the prior expression is what follow the
;; marker. For example the evaluation of the expression `(+ 1 1)` with
;; its result will be noted as follow:
;;
;;     (+ 1 1)
;;     ;;=> 2
;;
;; ### Booleans<a name="here">&nbsp;</a>
;;
;; In Clojure we have boolean values like in many other languages.  No
;; surprise here we have two values `true` and `false` which just
;; evaluate to themselves.  Now we can use the function `type` to see
;; what is the concrete type of these values in the host platform, and
;; if we check the type of these values we'll find that they are just
;; simple Java `java.lang.Boolean` objects.
;;

true
;;=> true

false
;;=> false

(type true)
;;=> java.lang.Boolean

;;
;; Now boolean values are often associated to **logic programming** and
;; the concept of **"truthiness"**. In strongly typed languages such as Java
;; you can only use boolean in conditional operation.
;; Some other languages such C/C++ have a more lose definition **"truthiness"**.
;; __In Clojure everything is considered **true** with the exception of `false`
;; and `nil`.__
;;
;; For example we can use the following form `(if condition truthy falsey)`
;; which evaluates the given `condition` and if the condition has a logical
;; value of true then it will evaluate `truthy` form otherwise it evaluates
;; the `falsey`.
;;

(if true "it's true" "it's false")
;;=> "it's true"

(if false "it's true" "it's false")
;;=> "it's false"

(if nil "it's true" "it's false")
;;=> "it's false"

(if "HELLO" "it's true" "it's false")
;;=> "it's true"

(if 1 "it's true" "it's false")
;;=> "it's true"





;;
;; ### test.

(*
 (+ 1 2 3 4)
 (- 12 3 4)
 )

;;
;; end.
