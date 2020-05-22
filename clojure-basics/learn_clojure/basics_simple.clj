(ns learn-clojure.basics-simple
  (:require [clojure.string :as str]))

;;
;; ## Clojure basics
;;
;; Clojure basics, ground up, with no assumption
;; of previous Clojure knowledge (just general
;; programming).
;;

;; ### The REPL
;;
;; REPL stands for Read Eval Print Loop.
;;
;; Many languages have REPLs but none allow
;; for a full range of in-flow development
;; such as LISP ones.
;;
;; Better than TDD, the **REPL Driven Development**
;; offers the fastest feedback.
;;
;;
;; ### Clojure syntax
;;
;; Syntax is based on `s-expressions`
;; a regular markup language which
;; gives the power to LISP macro system.
;;
;; General format is:
;; ( funciton arg1 arg2 ... argn )

;; The key is `homoiconicity`!!!

;;
;; ### Comments

;; this is a valid comment
;; and will be skipped by the reader

;; the next line is logical comment
;; more line a NO-OP instruction
(comment "something") ; in-line comment

;; but it requires to have valid clojure
(comment a : b : c)  ; this is BAD

;;
;; ### The function call.
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
;; Examples:
;;
;;     // java
;;     "Hello World!".toLowerCase();
;;
;;     // C - single char
;;     tolower(*c);
;;     // C - Whole string
;;     for ( ; *c; ++c) *c = tolower(*c);
;;                          ^^^^^^^^^^^^^
;;
;;     ;; Clojure
;;     (lower-case "Hello World!")
;;


;; ### Simple values
;;
;; Al simple values evaluate to themselves.

true
false

nil

1
-4
29384756298374652983746528376529837456

127 ;;=> 127              ; decimal
0x7F ;;=> 127             ; hexadecimal
0177 ;;=> 127             ; octal
32r3V ;;=> 127            ; base 32
2r01111111 ;;=> 127       ; binary
36r3J ;;=> 127            ; base 36

36rClojure ;;=> 27432414842
2r0111001101010001001001 ;;=> 1889353

;;
;; In Clojure there are no operators, in fact `+`,
;; `-`, `*` and `/` are normal functions.
;;

(+ 1 2 3 4 5)

;;
;; You can access static fields by
;; providing the fully qualified class name
;; followed by a slash (`/`) and the field name,
;; for example: `java.lang.Long/MAX_VALUE`.
;; Numbers can be auto-promoted using appropriate
;; functions like `+'` and `*'`

(+  1 java.lang.Long/MAX_VALUE)
(+' 1 java.lang.Long/MAX_VALUE)
(*' java.lang.Long/MAX_VALUE java.lang.Long/MAX_VALUE)


3.2
(type 3.2)
(type 3.2M)
(+ 0.3  0.3  0.3  0.1 ) ;; floating point
(+ 0.3M 0.3M 0.3M 0.1M) ;; big-decimal

(/ 1 3)
(type 1/3)
(+ 1/3 1/3 1/3)
(/ 21 6)
(+ 1/3 1/3 1/3 4)



\a       ; this is the character 'a'
\A       ; this is the character 'A'
\\       ; this is the character '\'
\u0041   ; this is unicode for  'A'
\tab     ; this is the tab character
\newline ; this is the newline character
\space   ; this is the space character

\a ;;=> \a
(type \a)



"This is a string"
(type "This is a string")

"Strings in Clojure
 can be multi lines
 as well!!"

;; java inter-operation
;; "This is a String".toUpperCase()
(.toUpperCase "This is a String")

(str "This" " is " "a" " concatenation.")
(str "Number of lines: " 123)


;; ## Conditionals & Flow control
;;
;; `truthiness` in Clojure
;; `nil` and `false` are falsey, everything
;; else is truthy
;;
;;     (if condition
;;         then-expr
;;         else-expr)
;;
;;
;;     (cond
;;        condition1 expr1
;;        condition2 expr2
;;        condition3 expr3
;;        :else default-expr)
;;
;; There are more options for flow control in Clojure
;; i.e `if`,`not`, `and`, `or`, `if-not`,
;; `when`, `when-not`, `cond` and `case`.


(if true "it's true" "it's false")
(if false "it's true" "it's false")
(if nil "it's true" "it's false")
(if "HELLO" "it's true" "it's false")
(if 1 "it's true" "it's false")


;; ### Keywords
;;

:blue

(type :this-is-a-keyword)

(keyword "blue")

(= :blue :blue)
;;=> true

(= (str "bl" "ue") (str "bl" "ue"))
(identical? (str "bl" "ue") (str "bl" "ue"))

(identical? :blue :blue)
(identical? (keyword (str "bl" "ue"))
            (keyword (str "bl" "ue")))


;;
;; ### Collections
;;
;; Collections in Clojure are:
;;  - Immutable by default
;;  - Persistent data structures (sharing)
;;  - Just values (like 42)
;;  - Every collection can hold any value


;;
;; #### Lists
;;
;; Clojure has single-linked lists built-in and
;; like all other Clojure collections are
;; immutable.  Lists guarantee `O(1)` insertion on
;; the head, `O(n)` traversal and element search.
;;

(list 1 2 3 4 5)

(cons 0 (list 1 2 3 4 5))

;; As the output suggest the lists literals in
;; Clojure are expressed with a sequence of values
;; surrounded by brackets, which is the same of
;; the function call. That is the reason why the
;; following line throws an error.

(1 2 3 4 5)

(quote (1 2 3 4 5))
'(1 2 3 4 5)

'(1 "hi" :test 4/5 \c)


;; you can get the head of the list with the
;; function `first` and use `rest` or `next` to
;; get the tail. `count` returns the number of
;; elements in it. `nth` returns the nth element
;; of the list, while `last` returns last item in
;; the list.
;;

(first '(1 2 3 4 5))
(rest '(1 2 3 4 5))
(next '(1 2 3 4 5))
(rest '(1))
(next '(1))
(count '(5))
(count '(1 2 3 4 5))

(nth '(1 2 3 4 5) 0)
(nth '(1 2 3 4 5) 1)
(nth '(1 2 3 4 5) 10)
(nth '(1 2 3 4 5) 10 :not-found)
(last '(1 2 3 4 5))
(last '(1))
(last '())


;;
;; #### Vectors
;;
;; Vectors are collections of values which are
;; indexed by their position in the vector
;; (starting from 0) called **index**. Insertion
;; at the end of the vector is `near O(1)` as well
;; as retrieval of an element by it's index.  The
;; literals is expressed with a sequence of values
;; surrounded by square brackets or you can use
;; the `vector` function to construct one.  You
;; can append an element at the end of the vector
;; with `conj` and use `get` to retrieve an
;; element in a specific index. Function such as
;; `first`, `next` `rest`, `last` and `count` will
;; work just as fine with Vectors.

[1 2 3 4 5]
[1 "hi" :test 4/5 \c]
(vector 1 2 3 4 5)
(conj [1 2 3 4 5] 6)
(count [1 2])
(first [:a :b :c])
(get [:a :b :c] 1)
(get [:a :b :c] 10)
(get [:a :b :c] 10 :z)


;; #### Maps
;;
;; Maps are associative data structures (often
;; called dictionaries) which maps keys to their
;; corresponding value.  Maps have a literal form
;; which can be expressed by any number of
;; key/value pairs surrounded by curly brackets,
;; or by using `hash-map` or `array-map`
;; functions. Hash-maps provides a `near O(1)`
;; insertion time and `near O(1)` seek time.  You
;; can use `assoc` to "add or overwrite" an new
;; pair, `dissoc` to "remove" a key and its value,
;; and use `get` to retrieve the value of a given
;; key.

{"jane" "jane@acme.com"
 "fred" "fred@acme.com"
 "rob"  "rob@acme.com"}

{:a 1, :b 2, :c 3}
(hash-map :a 1, :b 2, :c 3)
(array-map :a 1, :b 2, :c 3)
(assoc {:a 1, :b 2, :c 3} :d 4)
(assoc {:a 1, :b 2, :c 3} :b 10)
(dissoc {:a 1, :b 2, :c 3} :b)
(count {:a 1, :b 2, :c 3})
(get {:a 1, :b 2, :c 3} :a)
(get {:a 1, :b 2, :c 3} :a :not-found)
(get {:a 1, :b 2, :c 3} :ZULU :not-found)

(:a  {:a 1, :b 2, :c 3})

;;
;; #### Sets
;;
;; Sets are a type of collection which doesn't
;; allow for duplicate values.  While lists and
;; vector can have duplicate elements, set
;; eliminates all duplicates.  Clojure has a
;; literal form for sets which is expressed by a
;; sequence of values surrounded by `#{
;; }`. Otherwise you construct a set using the
;; `set` function.  With `conj` you can "add" a
;; new element to an existing set, and `disj` to
;; "remove" an element from the set.  With
;; `clojure.set/union`, `clojure.set/difference`
;; and `clojure.set/intersection` you have typical
;; sets operations.  `count` returns the number of
;; elements in the set in `O(1)` time.

#{1 2 4}
#{:a 4 5 :d "hello"}
(type #{:a :z})
(set [:a :b :c])
(conj #{:a :c} :b)
(conj #{:a :c} :c)
(disj #{:a :b :c} :b)
(clojure.set/union #{:a} #{:a :b} #{:c :a})
(clojure.set/difference #{:a :b} #{:c :a})
(clojure.set/intersection #{:a :b} #{:c :a})


;;
;; ### The sequence abstraction
;;
;; One of the most powerful abstraction of
;; Clojure's data structures is the `sequence`
;; (`clojure.lang.ISeq`) which all data structure
;; implements. This interface resembles to a Java
;; iterator, and it implements methods like
;; `first()`, `rest()`, `more()` and `cons()`. The
;; power of this abstraction is that it is general
;; enough to be used in all data structures
;; (lists, vectors, maps, sets and even strings
;; can all produce sequences) and you have loads
;; of functions which manipulates it. Functions
;; such as `first`, `rest`, `next` and `last` and
;; many others such as `reverse`, `shuffle`,
;; `drop`, `take`, `partition`, `filter` etc are
;; all built on top of the sequence abstraction.
;; So if you create your own data-structure and
;; you implement the four methods of the
;; `clojure.lang.ISeq` interface you can benefit
;; from all these function without having to
;; re-implement them for your specific
;; data-structure.
;;

(first [1 2 3 4])
(take 3 [:a :b :c :d :e])
(shuffle [1 2 3 4])
(shuffle #{1 2 3 4})
(reverse [1 2 3 4])
(last (reverse {:a 1 :b 2 :c 3}))


(seq "Hello World!")
(first "Hello")
(rest "Hello")
(count "Hello World!")

;;
;; #### Lazy Sequences
;;
;; Some of the sequences produced by the core
;; library are lazy which means that the entire
;; collection won't be created (*realised*) all at
;; once but when the elements are requested.

(range 5 10)

;; _**WARNING!!!** Evaluating this from your REPL
;; might hang/crash your process_, as it will try
;; evaluate an infinite lazy sequence all at once.

(range)

(take 10 (range))


;;
;; ### Regular expression patterns
;;

#"[\w\d.-]+@[\w\d-.]+\.[\w]+"


(type #"[\w\d.-]+@[\w\d-.]+\.[\w]+")

(re-find #"[0-9]+" "only 123 numbers")
(re-find #"[0-9]+" "no numbers")
(re-find #"[\w\d.-]+@[\w\d-.]+\.[\w]+"
         "bob.smith@acme.org")

(if (re-find #"^[\w\d.-]+@[\w\d-.]+\.[\w]+$"
             "bob.smith@acme.org")
  "it's an email"
  "it's not an email")


(re-seq #"[0-9]+" "25, 43, 54, 12, 15, 65")

(re-pattern "[0-9]{1,3}(\\.[0-9]{1,3}){3}")

(re-find
 (re-pattern "[0-9]{1,3}(\\.[0-9]{1,3}){3}")
 "my IP is: 192.168.0.12")


;;
;; Using `re-matcher`, `re-matches`, `re-groups`
;; allows you to have fine control over the capturing
;; groups.


;;
;; ### Symbols and Vars
;;
;; Symbols in Clojure are a way to identify things
;; in your programs which may have various values
;; at runtime. Like in a mathematical notation, `x`
;; is something not known which could assume
;; several different values.  In a programming
;; context, Clojure symbols are similar to
;; variables in other languages but not exactly.
;; In other languages variables are places where
;; you store information, symbols in Clojure
;; cannot contain data themselves.  Vars in
;; Clojure are the containers of data (one type
;; of), and symbols are a way to identify them and
;; give vars meaningful names for your program.
;;

username
'username

(symbol "username")
(type (symbol "username"))

(def username "bruno1")
username

age ;; undefined var produces error
(def age 21)

age

(type 'age)
(type age)


(def user {:username "bruno1"
           :score    12345
           :level    32
           :achievements #{:fast-run :precision10
                           :strategy}})

user

(def user nil)

user


;;
;; ### Immutability
;;
;; All basics data-types in Clojure are immutable,
;; including the collections. This is a very
;; important aspect of Clojure approach to
;; functional programming.  In Clojure functions
;; transform values into new values and values are
;; just values. Since it is absurd to think of
;; changing a number (1 is always 1),
;; composite data structures are treated in the same way.
;; So functions do not mutate values they just produce new ones.
;; Like adding `1` to `42` produces `43` but
;; doesn't really change the number `42` as it keeps on
;; existing on its own, adding an element to a list will
;; produce a new list but the old one will still be same
;; and unmodified.
;;
;; The advantage of the immutability is that
;; values (even deeply nested and complex
;; structures) can be safely shared across threads
;; and with function callers without worrying
;; about unsafe or uncoordinated changes.  This
;; simple constraint makes Clojure programs so
;; much easier to reason about, as the only way to
;; produce a new value is via a functional
;; transformation.
;;

(def colours '(:red :green :blue))

(def new-colours (cons :black colours))


new-colours
colours


(def user {:username "bruno1"
           :score    12345
           :level    32})

(def user' (assoc user :level 33))

user'
user

;;
;; ### Functions
;;
;; So far we have seen how to represent data in
;; our system, now we will see how to make sense
;; of this data and how to
;; extract/process/transform it.  The way we
;; express this in Clojure is via functions.
;;
;;

;; pure
(+ 1 2 3)

;; impure
(rand-int 100)

;; (+ 1 1 1) is referentially transparent
(+ 1 2 (+ 1 1 1))


;;
;; #### Function definition
;;
;; To define a function you have to use the
;; special form `fn` or `defn` with the following
;; syntax.
;;
;; for example if we want to define a function
;; which increments the input parameters by 1 you
;; will write something as follow:
;;
;; ```
;;   /- fn, special form
;;  /  parameter vector, 1 param called `n`
;;  |  |  body -> expression to evaluate when
;;  |  |  |       this function is called
;; (fn [n] (+ n 1))
;; ```
;;
;; This is the simplest way to define a function.
;;
;; Now to refer to this function in our code we
;; need to give it a name. We can do so with `def`
;; as we done earlier.
;;

(def plus-one (fn [n] (+ n 1)))
;;=> #'learn-clojure.basics/plus-one

(plus-one 10)
;;=> 11

(plus-one -42)
;;=> -41

;;
;; As mentioned earlier, during the evaluation process
;; the symbol `plus-one` is simply replaced with
;; its value, in the same way we can replace the
;; symbol with the function definition and obtain
;; the same result.  So symbols can also refer to
;; functions.

;; Evaluation by substitution model.
(plus-one        10)
((fn [n] (+ n 1)) 10)
(fn [10] (+ 10 1))
(+ 10 1)
11


;; def + fn = defn

(defn plus-one [n]
  (+ n 1))


(plus-one 1)


(defn plus-one
  "Returns a number which is one greater than the given `n`."
  [n]
  (+ n 1))


(inc 10)


(defn make-ip4
  [a b c d]
  (clojure.string/join "." [a b c d]))

(make-ip4 192 168 0 1)


(defn make-kebab
  [& words]
  (clojure.string/join "-" words))


(make-kebab "i" "like" "kebab")


(defn greet
  ([]
   "Hey, Stranger!")
  ([name]
   (str "Hello " name))
  ([firstname lastname]
   (str "Hi, you must be: " lastname ", " firstname " " lastname))
  ([title firstname lastname]
   (str "Hello " title " " firstname " " lastname)))

(greet)
(greet "James")
(greet "James" "Bond")
(greet "Dr" "John H." "Watson")


;;
;; #### High-order functions
;;
;; In Clojure functions are reified constructs,
;; therefore we can threat them as normal
;; values. As such functions can be passed as
;; parameters of function or returned as result of
;; function call.
;;

(defn is-commutative?
  [op a b]
  (= (op a b) (op b a)))

(is-commutative? + 3 7)
(is-commutative? / 3 7)


;; function which return a function
(defn multiplier
  [m]
  (fn [n]
    (* n m)))


(def doubler (multiplier 2))
(doubler 5)
(doubler 10)

(def mult-10x (multiplier 10))
(mult-10x 35)

;;
;; #### Lambda functions (Anonymous)
;;
;; Oftentimes you want to create a function for a
;; specific task in a local context. Such
;; functions don't have any reason to have a
;; global name as they are meaningful only in that
;; specific context, in this case you can create
;; anonymous functions (also called lambda
;; function) and Clojure has some support to make
;; this easier.  We already seen an example of an
;; anonymous function with our very first function
;; example.
;;

(fn [n] (+ n 1))

((fn [n] (+ n 1)) 10)
;;=> 11

#(+ % 1)
(#(+ % 1) 10)

;;
;; In this function the symbol `%` replace the argument
;; If you have more than one parameter you can denote them as
;; `%1` (or `%`), `%2`, `%3`, `%4` ...
;;
;; for example in our `is-commutative?` function we expect
;; and operation which accept two arguments:

(is-commutative? #(+ %1 %2) 9 8)


;;
;; #### Closures
;;
;; Closures (with the `s`) are lambdas which refer
;; to a context (or values from another context).
;; These functions are said to be "closing over"
;; the environment. This means that it can access
;; parameters and values which are NOT in the
;; parameters list.
;;

;; Like in our `multiplier` function example, the
;; returned function is closing over the value `m`
;; which is not in its parameter list but it is a
;; parameter of the parent context the
;; `multiplier` fn. While `n` is a normal
;; parameter `m` is the value we are "closing
;; over" providing a context for that function.

(defn multiplier
  [m]
  (fn [n]
    (* n m)))


;;
;; #### Recursion
;;
;; A recursive function is a function which
;; calls itself. There are two types of recursion
;; the mundane recursion and the tail recursion.
;;
;; Let's see an example of both with this function
;; which given a number it calculates the sum of
;; all natural numbers from 1 to the given
;; number.

(defn sum1
  ([n]
   (sum1 n 0))
  ([n accumulator]
   (if (< n 1)
     accumulator
     ;; else
     (sum1 (dec n) (+ n accumulator)))))


(sum1 1)

(sum1 3)

(sum1 10)

;;
;; This type of recursion is called mundane
;; recursion and every new call it allocates one
;; new frame on the stack so if you run this with
;; high enough numbers it will blow your stack.
;;

(sum1 10000)
;;=> java.lang.StackOverflowError

;;
;; Let's see how we can write this
;; function with a tail recursion using
;; `recur`.
;;

(defn sum2
  ([n]
   (sum2 n 0))
  ([n accumulator]
   (if (< n 1)
     accumulator
     ;; else
     (recur (dec n) (+ n accumulator)))))
;;=> #'learn-clojure.basics/sum2

(sum2 10)

(sum2 10000)

(sum2 1000000)

(sum2 100000000)


;; Let's see how we can rewrite the previous
;; function to leverage the `loop/recur`
;; construct.

(defn sum3
  [num]
  (loop [n           num
         accumulator 0]
    (if (< n 1)
      accumulator
      ;; else
      (recur (dec n) (+ n accumulator)))))


(sum3 10)


;; Let's see another example with the Fibonacci
;; sequence. Let's start with the mundane
;; recursion.

;; !!! this is O(2^n)
(defn fibonacci1
  [n]
  (if (< n 2)
    1
    ;; else
    (+ (fibonacci1 (- n 1))
       (fibonacci1 (- n 2)))))


(fibonacci1 1)

(fibonacci1 10)


;;
;; Now this is a simple and very functional
;; definition of the Fibonacci sequence, however
;; it is particularly bad in terms of computational
;; complexity.  in fact this is `O(2^n)`.
;; Let's use the `time` function to
;; calculate how much it takes to compute the
;; 35th number in the sequence.
;;

(time
 (fibonacci1 35))

;;
;; Let's try to use tail recursion.
;; As you will see we have to restructure
;; our function to allow the recursion
;; to happen in the tail position.
;;


(defn fibonacci2
  [n]
  (loop [i n c 1 p 1]
    (if (< i 2)
      c
      (recur (dec i) (+' c p) c))))

(fibonacci2 10)


(time
 (fibonacci2 35))


(time
 (fibonacci2 1000))




;;
;; #### Function composition and partial functions
;;
;; We have seen earlier that there are functions
;; such as `first`, `second`, `last` and `rest` to
;; access respectively the first item of the
;; sequence, the second item, the last item and
;; the tail of the sequence.  These functions can
;; be combined to create other functions for
;; accessing the third, fourth, fifth and other
;; positional items.  The following functions are
;; an example of how to construct two such
;; functions.

(defn third
  [coll]
  (first (rest (rest coll))))

(third '(1 2 3 4 5))
;;=> 3

(defn fourth
  [coll]
  (first (rest (rest (rest coll)))))

(fourth '(1 2 3 4 5))
;;=> 4

;; But there is another way.  If, like in this
;; case, the output of a function can be passed
;; directly into the input of the next one as a
;; simple pipeline of functions then you can just
;; use the `comp` function.
;;
;;      (comp f1 f2 f3 ... fn)
;;
;;      (comp f1 f2 f3) = (f1 (f2 (f3 ,,,)))
;;
(def third (comp first rest rest))
(def fourth (comp first rest rest rest))

(third '(1 2 3 4 5))
;;=> 3

(fourth '(1 2 3 4 5))
;;=> 4

;; Let's see another example. Let's assume
;; we have to write a function which given
;; a number it doubles it and subtract 1
;; from it. So we can use the `multiplier`
;; function we wrote earlier to accomplish
;; the first part and the Clojure core `dec`
;; to decrement it by one and compose them
;; together with `comp`.

(defn multiplier [m]
  (fn [n]
    (* n m)))

(def doubler (multiplier 2))
(def almost-twice (comp dec doubler))

(almost-twice 5)
;;=> 9

(almost-twice 9)
;;=> 17

;;
;; Now let's say we want to create a function
;; which given a number perform `almost-twice` two
;; times.
;;

(def almost-twice-twice (comp almost-twice almost-twice))

(almost-twice-twice 5)
;;=> 17

(almost-twice-twice 10)
;;=> 37

;; Another way we could have written the `doubler`
;; function is by using the partial application of
;; the function `*`. In Clojure this is achieved
;; via the function `partial`.
;;
;;      (partial f arg1 ... argn)
;;

(def doubler (partial * 2))

(doubler 5)
;;=> 10

;; what happens here is that the `partial`
;; function returns a function which calls `*`
;; with the parameters of the partial and the
;; parameter of the final call, all in one call.
;;


;;
;;
;; ### Vars, namespaces, scope and local bindings
;;
;; When defining a var using `def` or `defn`
;; followed by symbol, the symbol is created
;; in the local namespace.
;; When starting the REPL in a empty project
;; the default namespace is called `user`
;; so unless you configure differently
;; all your vars will be created there.
;;
;; Namespaces are like containers in which
;; vars live in, but namespaces,
;; once defined are **globally accessible**.
;; As a consequence when you define a var
;; using `def` or `defn` these will be accessible
;; globally.
;;
;; We will use `ns` which create a namespace if
;; not present and switch to it, and `in-ns` just
;; changes the current namespace.  we will see how
;; to loads namespaces we need with our processing
;; with `require` and how vars are globally
;; accessible.


(ns user.test.one)
;;=> nil

(def my-name "john")
;;=> #'user.test.one/my-name

my-name
;;=> "john"

(ns user.test.two)
;;=> nil

(def my-name "julie")
;;=> #'user.test.two/my-name

my-name
;;=> "julie"

user.test.one/my-name
;;=> "john"

user.test.two/my-name
;;=> "julie"


(def my-name (clojure.string/upper-case "john"))
;;=> #'user.test.one/my-name

(ns user.test.one
  (:require [clojure.string :as s]))
;;=> nil

(def my-name (s/upper-case "john"))
;;=> #'user.test.one/my-name

(ns user.test.one
  (:require [clojure.string :refer [upper-case]]))
;;=> nil

(def my-name (upper-case "john"))
;;=> #'user.test.one/my-name

my-name
;;=> "JOHN"

;;
;; The global accessible vars (globals) is one
;; level of scoping. If you don't want to have
;; globally accessible vars then you have to
;; use local bindings.
;;
;; We already had a glimpse of these while
;; defining functions. In fact parameters
;; are only visible inside the function:
;;

(def v1 1)
(def v2 2)

(defn sum
  [v1 v2]
  (+ v1 v2))


(sum 10 25)
;;=> 35

v1
v2
;;
;; There is another way to create local binding
;; which are valid only inside the s-expr block,
;; using `let`.  With the let form you can create
;; local variable which are visible only inside
;; the block.

(let [v1 23
      v2 45]
  ;; inside this block v1 v2 have the values 23 and 45
  (+ v1 v2))
;;=> 68

;;
;; outside the block v1 and v2 are resolved in the
;; parent scope which in this case is the
;; namespace/global You can even nest `let`
;; bindings and use them inside functions.  Here
;; we use `println` to print to the standard
;; output a message

(let [v1 "this is a local value"] ;; outer block
  (println "outer-v1:" v1)

  (let [v1 1] ;; inner block
    (println "inner-v1:" v1))

  (println "after-v1:" v1))

(println "global-v1:" v1)  ;; global

;;=> outer-v1: this is a local value
;;=> inner-v1: 1
;;=> after-v1: this is a local value
;;=> global-v1: hello



;;
;; ### Core functions
;;
;; The core has hundreds of functions defined,
;; which all work on the basic data structures
;; that we've seen so far. You can find the full list
;; in the [Clojure cheatsheet](http://clojure.org/api/cheatsheet)
;;
;;
;; #### The function: `apply`
;;
;; For the purpose of this course we will
;; only see a few examples starting with `apply`.
;; As the same suggests, it "applies" a function
;; to a given list of arguments.
;;
;;      (apply f args)
;;      (apply f x args)
;;

(def words ["Hello" " " "world!"])

(str ["Hello" " " "world!"])
;;=> "[\"Hello\" \" \" \"world!\"]"

(apply str ["Hello" " " "world!"])
;;=> "Hello world!"

(apply str "first-argument: " ["Hello" " " "world!"])
;;=> "first-argument: Hello world!"

;;
;; #### The function: `map`
;;
;; Next we will see one of the most used functions
;; in the core `map` which has nothing to do with
;; the associative maps (data structures) we seen
;; before.  `map` comes from the set theory and is
;; a function which takes a function and a
;; sequence of values and applies the function to
;; all values in the sequence. It returns a
;; lazy-sequence which means that the function
;; application is not performed when calling `map`,
;; but it will be performed when the result will
;; be consumed.
;;
;;      (map f coll)
;;

(map clojure.string/upper-case
     ["Hello" "world!"])
;;=> ("HELLO" "WORLD!")

;;
;; #### The function: `mapcat`
;;
;; Sometimes the application of the function `f`
;; returns a list of things. In the following
;; example, applying the split function to each sentence
;; spilts each sentence and returns a list of words.
;;

(map #(clojure.string/split % #"\W+")
     ["Lorem ipsum dolor sit amet, consectetur adipiscing elit."
      "Duis vel ante est."
      "Pellentesque habitant morbi tristique"
      "senectus et netus et malesuada fames ac turpis egestas."])


;; application of the split function to a single
;; sentence produces a list of words. Consequently
;; the application of the function to all
;; sentences produces a list of lists.  If we
;; rather have a single list with all the words we
;; then need to concatenate all the sub-lists into
;; one.  To do so Clojure core has the `concat`
;; function which just concatenates multiple lists
;; into one.

(concat [0 1 2 3] [:a :b :c] '(d e f))
;;=> (0 1 2 3 :a :b :c d e f)

;; To obtain a single list of all words we just need
;; to apply the `concat` function to the `map` result.

(apply concat
       (map #(clojure.string/split % #"\W+")
            ["Lorem ipsum dolor sit amet, consectetur adipiscing elit."
             "Duis vel ante est."
             "Pellentesque habitant morbi tristique"
             "senectus et netus et malesuada fames ac turpis egestas."]))
;;=> ("Lorem" "ipsum" "dolor" "sit" "amet" "consectetur" "adipiscing" "elit" "Duis" "vel" "ante" "est" "Pellentesque" "habitant" "morbi" "tristique" "senectus" "et" "netus" "et" "malesuada" "fames" "ac" "turpis" "egestas")

;;
;; This construct is common enough that Clojure has
;; a core function that does just this called `mapcat`.

(mapcat #(clojure.string/split % #"\W+")
        ["Lorem ipsum dolor sit amet, consectetur adipiscing elit."
         "Duis vel ante est."
         "Pellentesque habitant morbi tristique"
         "senectus et netus et malesuada fames ac turpis egestas."])
;;=> ("Lorem" "ipsum" "dolor" "sit" "amet" "consectetur" "adipiscing" "elit" "Duis" "vel" "ante" "est" "Pellentesque" "habitant" "morbi" "tristique" "senectus" "et" "netus" "et" "malesuada" "fames" "ac" "turpis" "egestas")

;;
;;
;; #### The function: `reduce`
;;
;; Hadoop uses the two concept of `map` and
;; `reduce` to perform arbitrary computation on
;; large data.  Clojure has `reduce` as core
;; function as well.  While `map` is applied
;; one-by-one to all arguments with the objective
;; of performing a transformation `reduce` seeks
;; to summarize many values into one.  For example
;; if you want to find the total sum of a list of
;; values you can use reduce in the following way.
;;
;;      (reduce f coll)
;;
;; It can be used with many core functions
;; like the arithmetic functions `+`, `*`
;; but also with functions like `max` and `min`
;; which respectively return the highest and
;; the lowest value passed. But they
;; can be used with your own functions too.
;;

(reduce + [10 15 23 32 43 54 12 11])
;;=> 200

(reduce * [10 15 23 32 43 54 12 11])
;;=> 33838041600

(reduce max [10 15 23 32 43 54 12 11])
;;=> 54

(reduce str ["Hello" " " "world!"])
;;=> "Hello world!"


;;
;; #### The function: `filter`
;;
;; The next function in the core is `filter` which
;; takes a *predicate function* and a collection
;; and returns a lazy-sequence of the items in the
;; collection for which the application of the
;; function returns a "truthy" value.  Predicate
;; functions are functions which takes one
;; parameter and return a logical true or false.
;;
;;      (filter pred? coll)
;;
;; For example:

(filter odd? [0 1 2 3 4 5 6 7])
;;=> (1 3 5 7)

(filter #(> (count %) 5)
        ["Lorem" "ipsum" "dolor" "sit" "amet" "consectetur" "adipiscing"])
;;=> ("consectetur" "adipiscing")

;;
;; `identity` is a function which given a value
;; will just return the value.
;; This is often used when a function transformation
;; is required as parameter, but no transformation is wanted.
;; another idiomatic use of it is to remove nil and false
;; from a collection.
;;

(filter identity
        ["Lorem" "ipsum" nil "sit" nil "consectetur" nil])
;;=> ("Lorem" "ipsum" "sit" "consectetur")

;;
;; The function `remove` is the dual of `filter`
;; in the sense that is will remove the items
;; for which the predicate function returns true.
;;

(filter odd? [0 1 2 3 4 5 6 7])
;;=> (1 3 5 7)

(remove odd? [0 1 2 3 4 5 6 7])
;;=> (0 2 4 6)

;;
;; #### The function: `sort`
;;
;; `sort` as you would expect returns a sorted
;; sequence of the elements in the given collection.
;;
;;      (sort coll)
;;      (sort comp coll)
;;

(sort [8 3 5 2 5 7 9 4 3 1 0])
;;=> (0 1 2 3 3 4 5 5 7 8 9)

(sort > [8 3 5 2 5 7 9 4 3 1 0])
;;=> (9 8 7 5 5 4 3 3 2 1 0)

(sort-by count
         ["Lorem" "ipsum" "dolor" "sit" "amet" "consectetur" "adipiscing"])
;;=> ("sit" "amet" "Lorem" "ipsum" "dolor" "adipiscing" "consectetur")

(sort-by count >
         ["Lorem" "ipsum" "dolor" "sit" "amet" "consectetur" "adipiscing"])
;;=> ("consectetur" "adipiscing" "Lorem" "ipsum" "dolor" "amet" "sit")

(sort-by :score >
         [{:user "john1" :score 345}
          {:user "fred3" :score 75}
          {:user "sam2"  :score 291}])
;;=> ({:user "john1", :score 345} {:user "sam2", :score 291} {:user "fred3", :score 75})

;;
;; A similar function is `sort-by` which accepts a
;; function which is applied to the item before the
;; comparison.
;;
;;
;; #### The function: `group-by`
;;
;; Out of the box in Clojure you have a function
;; to perform grouping on your data.  `group-by`
;; accepts a function and a collection and it will
;; apply the given function to all items in the
;; collection and then group the items using the
;; result of the function, i.e items that give the
;; same result when the function is applied end up
;; in the same group.  Each group will be
;; associated with it's common function result.
;; It returns a map where the key is the group
;; common function result, and the value of the
;; map is a list of items which belong to that
;; group.

(group-by odd? (range 10))
;;=> {false [0 2 4 6 8], true [1 3 5 7 9]}


(group-by count ["Lorem" "ipsum" "dolor" "sit" "amet" "consectetur" "adipiscing"])
;;=> {5 ["Lorem" "ipsum" "dolor"], 3 ["sit"], 4 ["amet"], 11 ["consectetur"], 10 ["adipiscing"]}

(group-by :user-id [{:user-id 1 :uri "/"}
                    {:user-id 2 :uri "/foo"}
                    {:user-id 1 :uri "/account"}])
;;=> {1 [{:user-id 1, :uri "/"} {:user-id 1, :uri "/account"}], 2 [{:user-id 2, :uri "/foo"}]}

;;
;; #### The function: `frequencies`
;;
;; When looking to count how frequent an item appears
;; in a collection for example to compute histograms
;; you can use the function called `frequencies`.
;;

(frequencies ["john" "fred" "alice" "fred" "jason" "john" "alice" "john"])
;;=> {"john" 3, "fred" 2, "alice" 2, "jason" 1}


(frequencies [1 2 3 1 2 3 2 3 1 2 3 3 2 3 2 3 4 4])
;;=> {1 3, 2 6, 3 7, 4 2}

;;
;;
;; #### The function: `partition`
;;
;; Another interesting group of functions in the Clojure
;; core are `partition`, `partition-all`, `partition-by`.
;; Here we will see only the first two.
;; `partition` chunks the given sequence into
;; sub-sequences (lazy) of `n` items each.
;;
;;      (partition n coll)
;;      (partition n step coll)
;;

(partition 3 (range 11))
;;=> ((0 1 2) (3 4 5) (6 7 8))

;; `partition-all` does the same, but it returns
;; also chunks of which are incomplete.

(partition-all 3 (range 11))
;;=> ((0 1 2) (3 4 5) (6 7 8) (9 10))

;;
;; The `step` parameters tells the function how
;; many item has to move forward after every
;; chunk.  if not given `step` is equal to `n`

(partition 3 1 (range 11))
;;=> ((0 1 2) (1 2 3) (2 3 4) (3 4 5) (4 5 6) (5 6 7) (6 7 8) (7 8 9) (8 9 10))

(partition 3 5 (range 11))
;;=> ((0 1 2) (5 6 7))

;;
;; #### The function: `into`
;;
;; `into` is used to create a new collection of a
;; given type with all items from another
;; collection "into" it.  Items are conjoined
;; using `conj`. It is often used to change the
;; type of a collection, or to build a map out of
;; key/value pairs.
;;
;;      (into dest source)
;;

(into [] '(0 1 2 3 4 5 6 7 8 9))
;;=> [0 1 2 3 4 5 6 7 8 9]

(into '() '(0 1 2 3 4 5 6 7 8 9))
;;=> (9 8 7 6 5 4 3 2 1 0)

(into (sorted-map) {:b 2, :c 3, :a 1})
;;=> {:a 1, :b 2, :c 3}

(into {} [[:a 1] [:b 2] [:c 3]])
;;=> {:a 1, :b 2, :c 3}

(map (fn [e] [(first e) (inc (second e))])
     {:a 1, :b 2, :c 3})
;;=> ([:a 2] [:b 3] [:c 4])

(into {}
      (map (fn [e] [(first e) (inc (second e))])
           {:a 1, :b 2, :c 3}))
;;=> {:a 2, :b 3, :c 4}

;;

;;
;; ### Operation with files
;;
;; To open, read, write files there are wrappers
;; from the java machinery for files. However here
;; we will only see how to read and write text
;; files which are small enough to fit in memory.
;;
;; To write some text in a file you can use the
;; function `spit`, while to read the content of a
;; file as a string you can use `slurp`.
;;

(spit "/tmp/my-file.txt"
      "This is the content")
;;=> nil


(slurp "/tmp/my-file.txt")
;;=> "This is the content."

;;
;; ### Error handling
;;
;; What happens if the file you trying to read
;; doesn't exists? or the device you trying to
;; write to is full? The underlying Java APIs will
;; throw an exception.  Clojure provides access to
;; the java machinery for error handling and you
;; can use `try`, `catch`, `finally` and `throw`
;; with the same semantic as the Java's ones.
;;
;; You have to surround the code which might throw
;; an exception using a `try` form, then you can
;; handle the errors by their native type with a
;; `catch` block.  Finally is a block that gets
;; executed no matter what happen in the try block and
;; whether or not an exception is raised.  `throw`
;; is used to throw an exception from your own code.

(slurp "/this_doesnt_exists.txt")
;;=> FileNotFoundException /this_doesnt_exists.txt (No such file or directory)


(try
  (slurp "/this_doesnt_exists.txt")
  (catch Exception x
    (println "unable to read file.")
    ""))
;;=> unable to read file
;;=> ""

;;
;; ### Destructuring
;;
;; The complete guide to Clojure destructuring
;; http://blog.brunobonacci.com/2014/11/16/clojure-complete-guide-to-destructuring/
;;
;;
;; ### Macros
;;
;; The macros are function which are executed at
;; compile time by the compiler. The take code as
;; input, and the output is still code. The code
;; is expressed in the same stuff you have seen so
;; far: lists, symbols, keywords, vectors, maps
;; strings etc and from a user point of view they
;; look just like normal Clojure functions
;; (almost).  It is a great way to extends the
;; language to meet your domain needs. However I
;; think this is a topic for a more advanced
;; course. If you want to learn the basics of the
;; macro you can read the following blog post:
;;
;; A "dead simple" introduction to Clojure macros.
;; http://blog.brunobonacci.com/2015/04/19/dead-simple-introduction-to-clojure-macros/
;;

(require '[clojure.string :as str])

(into #{} (map str/upper-case (str/split "this is a great language and a great platform" #" ")))


(->> (str/split "this is a great language and a great platform" #" ")
  (map str/upper-case)
  (into #{}))


(macroexpand
 '(->> (str/split "this is a great language and a great platform" #" ")
   (map str/upper-case)
   (into #{})))


;; can write a macro which turn my expression into a Go-like
;; expression which never throws exceptions?



;;
