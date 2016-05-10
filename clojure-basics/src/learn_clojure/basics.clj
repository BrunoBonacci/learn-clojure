(ns learn-clojure.basics)

;;
;; ## Clojure basics
;;
;; I will try to introduce concepts gradually
;; without assuming prior knowledge of Clojure (or
;; any other LISP dialect).  However I will assume
;; that you are already an experienced developer
;; in any other popular language such as Java,
;; C/C++, Python or Javascript.  General
;; programming concepts such as functions,
;; parameters, recursion, objects and common
;; data-structures such as: linked lists, maps (or
;; dictionaries), vectors and sets will be assumed
;; to be already known.
;;
;;
;; ### The REPL
;;
;; The REPL is (IMHO) one of the key Clojure's
;; feature. REPL stands for: __Read Eval Print
;; Loop__ and although is present in many
;; languages such as python, ruby and soon Java as
;; well, in Clojure is part of the main
;; development workflow. In other words if you are
;; not using the REPL for your Clojure development
;; you are doing it wrong!
;;
;; The REPL allows you to connect to a running
;; system, inspect runtime values, and even make
;; live changes in your code without having to
;; restart your system.
;;
;; It is the best way to explore a system or a
;; dataset and get familiar with its domain.
;;
;; In terms of feedback loop is way better than
;; the TDD at the point that is creating a new
;; development methodology the **REPL Driven
;; Development**
;;
;; For this session we are going to use the REPL
;; to explore Clojure features, this might give a
;; glimpse of what is possible to do with the
;; Clojure REPL.
;;
;;
;; ### Clojure syntax
;;
;; Clojure syntax is very simple.
;; A program is composed of s-expressions,
;; every s-expr is delimited by a set of
;; parenthesis. Line comments are made
;; with a semicolon (`;`) and by conventions
;; a full line comment is two or more consecutive
;; semicolons `;;` while and in-line comment
;; is only one `;`.
;;
;; You can skip the evaluation and execution of a
;; block with the `comment` form, however this
;; isn't a complete comment in the same way as the
;; semicolon, as it still get parsed by the reader
;; in the same way as the rest of the
;; code. Therefore the comment block has to be
;; valid Clojure code.  For example:
;;
;;      ;; this is a valid comment
;;      ;; a : b : c
;;      ;; while this won't be readable
;;      (comment a : b : c)
;;
;; The difference is that the semicolon comment is
;; ignored by the reader, while the `comment`
;; block is something that you could have
;; implemented yourself using the macros, which it
;; this case just tells the compiler to not
;; generate anything any code.
;;
;; We will denote the output of the REPL evaluation
;; with by prefixing the result with `;;=>`.
;; So every time you see a Clojure expression
;; followed by `;;=>` and a value it means
;; that the value is the result of the evaluation
;; of last expression.
;;
;; ### The function call.
;;
;; The first concept I will introduce is how to
;; make a function call.  We will see more about
;; functions later, but for the moment I want to
;; make sure that you will understand the next few
;; examples.  Let's start to make some comparisons
;; with method or function calls in a few
;; different languages
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
;; As you can see in Clojure the brackets surround
;; the function and all its arguments.  In object
;; oriented languages such as Java and C++ the
;; object comes before the method name or function
;; name. In C and Clojure the function comes
;; first, then followed by the target
;; object. Let's see a concrete example, _for the
;; sake of the example I will omit the required
;; package imports._
;;
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
;;
;; _NOTE: In the standard C library there is only
;; a function to turn a single character into its
;; lowercase form, that's why there is a loop._
;;
;; However in the `tolower(*c)` we can see the
;; function comes first followed by its arguments
;; surrounded by bracket.  In Clojure, the
;; expression (called `s-expr`) starts with an
;; open bracket, followed by a function followed
;; by a list of arguments.
;;
;; The following code is designed to run in the
;; Clojure REPL, the conventions I will follow
;; throughout the text is to display the result of
;; the expression evaluation prefixed with this
;; evaluation marker `;;=>`. So every time you'll
;; see a Clojure expression followed by `;;=>` and
;; followed by another value it means that the
;; result of the evaluation of the prior
;; expression is what follows the marker. For
;; example the evaluation of the expression `(+ 1
;; 1)` with its result will be noted as follow:
;;
;;     (+ 1 1)
;;     ;;=> 2
;;
;; ### Booleans
;;
;; In Clojure we have boolean values like in many
;; other languages.  No surprise here we have two
;; values `true` and `false` which just evaluate
;; to themselves.  Now we can use the function
;; `type` to see what is the concrete type of
;; these values in the host platform, and if we
;; check the type of these values we'll find that
;; they are just simple Java `java.lang.Boolean`
;; objects.
;;

true
;;=> true

false
;;=> false

(type true)
;;=> java.lang.Boolean

;;
;; Now boolean values are often associated to
;; **logic programming** and the concept of
;; **"truthiness"**. In strongly typed languages
;; such as Java you can only use boolean in
;; conditional operation.  Some other languages
;; such C/C++ have a more loose definition
;; **"truthiness"**.  __In Clojure everything is
;; considered **true** with the exception of
;; `false` and `nil`.__
;;
;; For example we can use the following form `(if
;; condition truthy falsey)` which evaluates the
;; given `condition` and if the condition has a
;; logical value of true then it will evaluate
;; `truthy` form otherwise it evaluates the
;; `falsey`.
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
;; ### Numbers
;;
;; Clojure has a quite unique support for
;; numerical values.  As you would expect every
;; number just evaluates to itself.
;;
;; #### Integers
;;
;; They are mapped to `java.lang.Long`, but since
;; they can be indefinitely large they can be
;; promoted to `clojure.lang.BigInt` once they go
;; beyond the `java.lang.Long#MAX_VALUE`.
;;

1 ;;=> 1
-4 ;;=> -4

9223372036854775807   ; java.lang.Long#MAX_VALUE
;;=> 9223372036854775807

(type 1)
;;=> java.lang.Long

(type 9223372036854775807)
;;=> java.lang.Long

29384756298374652983746528376529837456
;;=> 29384756298374652983746528376529837456N

(type 29384756298374652983746528376529837456)
;;=> clojure.lang.BigInt

(type 1N)
;;=> clojure.lang.BigInt

;;
;; You can also define integers literals in other basis
;; such as octal, hexadecimals and binary.
;;

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
;;=> 15

;;
;; You can access static fields by
;; providing the fully qualified class name
;; followed by a slash (`/`) and the field name,
;; for example: `java.lang.Long/MAX_VALUE`.
;;

java.lang.Long/MAX_VALUE
;;=> 9223372036854775807

(- java.lang.Long/MAX_VALUE 1)
;;=> 9223372036854775806

(+ 1 java.lang.Long/MAX_VALUE)
;;=> ArithmeticException integer overflow


;;
;; Clojure has a number of functions which will
;; automatically auto-promote the number to be
;; bigger type in case it doesn't fit in the 64bit
;; Java Long object. These functions are: `+'`,
;; `-'` and `*'`
;;

(+' 1 java.lang.Long/MAX_VALUE)
;;=> 9223372036854775808N

(*' java.lang.Long/MAX_VALUE java.lang.Long/MAX_VALUE)
;;=> 85070591730234615847396907784232501249N


;;
;; #### Decimals
;;
;; Clojure supports floating point decimals and
;; exact decimals.  Floating point decimals are
;; mapped to `java.lang.Double` and they evaluate
;; to themselves. While exact decimals are mapped
;; to `java.math.BigDecimal` and they also
;; evaluate to themselves.  Use the latter when
;; you require exact decimals but be careful to
;; numbers which can't be represented with exact
;; decimals like: 1 divided by 3 (0.3333333...) as
;; the the decimal part continue forever.
;;

3.2
;;=> 3.2

(type 3.2)
;;=> java.lang.Double

3.2M
;;=> 3.2M

(type 3.2M)
;;=> java.math.BigDecimal

(+ 0.3 0.3 0.3 0.1) ;; floating point
;;=> 0.9999999999999999

(+ 0.3M 0.3M 0.3M 0.1M) ;; big-decimal
;;=> 1.0M

(/ 1.0M 3.0M)
;;=> ArithmeticException Non-terminating decimal expansion; no exact representable decimal result.

(with-precision 10 (/ 1.0M 3.0M))
;;=> 0.3333333333M

;;
;; #### Rationals
;;
;; Number like 1 divided by 3 are called rational
;; numbers, and Clojure supports them. You can mix
;; then in your calculation and as long as you
;; don't put floating point values it will retain
;; the precision.
;;

(/ 1 3)
;;=> 1/3

(type 1/3)
;;=> clojure.lang.Ratio

(+ 1/3 1/3 1/3)
;;=> 1N

(/ 21 6)
;;=> 7/2

(+ 1/3 1/3 1/3 1)
;;=> 2N

(+ 1/3 1/3 0.333)
;;=> 0.9996666666666667


;;
;;
;; ### Characters
;;
;; So far we have seen the rich support for
;; numerical values in Clojure.  Clojure does
;; support characters and strings literals as
;; well.  Characters map to `java.lang.Character`,
;; support Unicode characters and as all
;; value-types they evaluate to themselves.
;;

\a       ; this is the character 'a'
\A       ; this is the character 'A'
\\       ; this is the character '\'
\u0041   ; this is unicode for  'A'
\tab     ; this is the tab character
\newline ; this is the newline character
\space   ; this is the space character

\a ;;=> \a

(type \a)
;;=> java.lang.Character

;;
;;
;; ### Strings
;;
;; Strings literals have no surprise. They map to
;; `java.lang.String`, they are multi-line, like
;; in Java they are immutable and they evaluate to
;; themselves.
;;

"This is a string"
;;=> "This is a string"

(type "This is a string")
;;=> java.lang.String

"Strings in Clojure
 can be multi lines
 as well!!"
;;=> "Strings in Clojure\n can be multi lines\n as well!!"

;;
;; Via the Java interop. infrastructure you can
;; call all `java.lang.String` methods directly
;;

(.toUpperCase "This is a String")
;;=> "THIS IS A STRING"

;;
;; You can use the function `str` to concatenate
;; strings or to convert numbers into strings (via
;; `Object#toString()` method).
;;

(str "This" " is " "a" " concatenation.")
;;=> "This is a concatenation."

(str "Number of lines: " 123)
;;=> "Number of lines: 123"


;;
;; ### Keywords
;;
;; Keywords are labels for things in our programs,
;; they evaluate to themselves and can be used to
;; give name to things similarly to Java's
;; enumerations.  They mostly used as key in maps
;; (we will see this later), and the Clojure
;; runtime maintains them in a internal pool
;; (similarly to interned strings in Java.)  which
;; guarantee that only one copy of a particular
;; keyword will ever exist in a program. For this
;; reason they provide very fast equality test.
;; Equality test in Clojure is done via the
;; function `=` with the same semantic as the
;; Java's `.equals()` method, while the identity
;; equality is done via the function `identical?`
;; which in turn implements the Java's `==`
;; operator.  You can use the function `keyword`
;; to create a keyword out of a string.
;;


:words
;;=> :words

(type :this-is-a-keyword)
;;=> clojure.lang.Keyword

(keyword "blue")
;;=> :blue

(= :blue :blue)
;;=> true

(= (str "bl" "ue") (str "bl" "ue"))
;;=> true

(identical? :blue :blue)
;;=> true

(identical? (str "bl" "ue") (str "bl" "ue"))
;;=> false

(identical? (keyword (str "bl" "ue")) (keyword (str "bl" "ue")))
;;=> true

;;
;; ### Collections
;;
;; In Java the only collection literals available
;; is the array.  Clojure like most modern
;; languages offers a variety of collection
;; literals which makes the language more
;; expressive. Out-of-the-box support is provided for
;; the following collections literals: single linked
;; lists, vectors, maps (or dictionaries) and
;; sets.  However Clojure supports a larger number
;; of data structures which are built with
;; functions such as: sorted maps, sorted sets,
;; array maps, hash maps and hash sets. Many more
;; data structures are available in community maintained
;; libraries such as graphs, ring buffers and AVL
;; trees. **All Clojure collections can contain a
;; mixture of values**.
;;
;;
;; #### Lists
;;
;; Clojure has single-linked lists built-in and
;; like all other Clojure collections are
;; immutable.  Lists guarantee `O(1)` insertion on
;; the head, `O(n)` traversal and element search.
;;

                                        ; to create a list you can use the function `list`
(list 1 2 3 4 5)
;;=> (1 2 3 4 5)

                                        ; to "add" an element on the front of the list you can
                                        ; use the `cons` function.
(cons 0 (list 1 2 3 4 5))
;;=> (0 1 2 3 4 5)

;; As the output suggest the lists literals in
;; Clojure are expressed with a sequence of values
;; surrounded by brackets, which is the same of
;; the function call. That is the reason why the
;; following line throws an error.

(1 2 3 4 5)
;;=> ClassCastException java.lang.Long cannot be cast to clojure.lang.IFn

;; To be able to express a list of values as a
;; literal we have to used the `quote` form which
;; it will preserve the list without initiate the
;; function call.

(quote (1 2 3 4 5))
;;=> (1 2 3 4 5)

;;
;; As syntax sugar we can use the single quote
;; sign `'` instead of the longer `(quote ,,,)`
;; form.
;;

'(1 2 3 4 5)
;;=> (1 2 3 4 5)

'(1 "hi" :test 4/5 \c)
;;=> (1 "hi" :test 4/5 \c)

;;
;; you can get the head of the list with the
;; function `first` and use `rest` or `next` to
;; get the tail. `count` returns the number of
;; elements in it. `nth` returns the nth element
;; of the list, while `last` returns last item in
;; the list.
;;

(first '(1 2 3 4 5))
;;=> 1

(rest '(1 2 3 4 5))
;;=> (2 3 4 5)

(next '(1 2 3 4 5))
;;=> (2 3 4 5)

(rest '(1))
;;=> ()

(next '(1))
;;=> nil

(count '(5))
;;=> 1

(count '(1 2 3 4 5))
;;=> 5

(nth '(1 2 3 4 5) 0)
;;=> 1

(nth '(1 2 3 4 5) 1)
;;=> 2

(nth '(1 2 3 4 5) 10)
;;=> IndexOutOfBoundsException

(nth '(1 2 3 4 5) 10 :not-found)
;;=> :not-found

(last '(1 2 3 4 5))
;;=> 5

(last '(1))
;;=> 1

(last '())
;;=> nil

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
;;=> [1 2 3 4 5]

[1 "hi" :test 4/5 \c]
;;=> [1 "hi" :test 4/5 \c]

(vector 1 2 3 4 5)
;;=> [1 2 3 4 5]

(conj [1 2 3 4 5] 6)
;;=> [1 2 3 4 5 6]

(count [1 2])
;;=> 2

(first [:a :b :c])
;;=> :a

(get [:a :b :c] 1)
;;=> :b

([:a :b :c] 1)
;;=> :b

(get [:a :b :c] 10)
;;=> nil

(get [:a :b :c] 10 :z)
;;=> :z

;;
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
;;=> {"jane" "jane@acme.com", "fred" "fred@acme.com", "rob" "rob@acme.com"}

{:a 1, :b 2, :c 3}
;;=> {:a 1, :b 2, :c 3}

(hash-map :a 1, :b 2, :c 3)
;;=> {:c 3, :b 2, :a 1}

(array-map :a 1, :b 2, :c 3)
;;=> {:a 1, :b 2, :c 3}

(assoc {:a 1, :b 2, :c 3} :d 4)
;;=> {:a 1, :b 2, :c 3, :d 4}

(assoc {:a 1, :b 2, :c 3} :b 10)
;;=> {:a 1, :b 10, :c 3}

(dissoc {:a 1, :b 2, :c 3} :b)
;;=> {:a 1, :c 3}

(count {:a 1, :b 2, :c 3})
;;=> 3

(get {:a 1, :b 2, :c 3} :a)
;;=> 1

(get {:a 1, :b 2, :c 3} :a :not-found)
;;=> 1

(get {:a 1, :b 2, :c 3} :ZULU :not-found)
;;=> :not-found

(:a {:a 1, :b 2, :c 3})
;;=> 1

({:a 1, :b 2, :c 3} :a)
;;=> 1

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
;;=> #{1 4 2}

#{ 1 1 3 5}
;;=> IllegalArgumentException Duplicate key: 1

#{:a 4 5 :d "hello"}
;;=> #{"hello" 4 5 :d :a}

(type #{:a :z})
;;=> clojure.lang.PersistentHashSet

(set [:a :b :c])
;;=> #{:c :b :a}

(conj #{:a :c} :b)
;;=> #{:c :b :a}

(conj #{:a :c} :c)
;;=> #{:c :a}

(disj #{:a :b :c} :b)
;;=> #{:c :a}

(clojure.set/union #{:a} #{:a :b} #{:c :a})
;;=> #{:c :b :a}

(clojure.set/difference #{:a :b} #{:c :a})
;;=> #{:b}

(clojure.set/intersection #{:a :b} #{:c :a})
;;=> #{:a}


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
;; You can create a sequence explicitly with the
;; `seq` function but there are loads of functions
;; which already return a sequence. The sequence
;; of a list is the list itself, other
;; data-structures will produce one.  Maps will
;; produce a sequence of map entries, where each
;; entry can be represented like a vector of two
;; values (the key and it's value.)
;;

(seq '(1 2 3 4))
;;=> (1 2 3 4)

(seq [1 2 3 4])
;;=> (1 2 3 4)

(seq #{1 2 3 4})
;;=> (1 4 3 2)

(seq {:a 1, :b 2, :c 3})
;;=> ([:a 1] [:b 2] [:c 3])

;;
;; There is no need to call `seq` explicitly, in
;; most of the cases, functions which take a
;; sequence can work with all data structures
;; directly.
;;

(first [1 2 3 4])
;;=> 1

(take 3 [:a :b :c :d])
;;=> (:a :b :c)

(shuffle [1 2 3 4])
;;=> [1 3 2 4]

(shuffle #{1 2 3 4})
;;=> [2 4 1 3]

(reverse [1 2 3 4])
;;=> (4 3 2 1)

(last (reverse {:a 1 :b 2 :c 3}))
;;=> [:a 1]

;;
;; Because the Clojure String implements the sequence
;; abstraction, you can treat the String as a sequence
;; of characters.
;;

(seq "Hello World!")
;;=> (\H \e \l \l \o \space \W \o \r \l \d \!)

(first "Hello")
;;=> \H

(rest "Hello")
;;=> (\e \l \l \o)

(count "Hello World!")
;;=> 12

;;
;; #### Lazy Sequences
;;
;; Some of the sequences produced by the core
;; library are lazy which means that the entire
;; collection won't be created (*realised*) all at once.
;; At first, an iterator like structure is created,
;; with subsequent calls to `next()` causing chunks
;; of items to be fetched/computed. This is a very important
;; element of the language which allows the easy expression
;; of infinite sequences without running out
;; of memory. For example the function `range`
;; returns a lazy sequence of natural numbers
;; between two given numbers. But when it is
;; called without arguments it returns a lazy
;; sequence of all natural numbers.  Yet it
;; doesn't run out of memory. What it really
;; produces is just an iterator that computes the
;; next chunk of numbers when `next()` is called.
;; NOTE: As subsequent calls are made to `next()`,
;; it is advisable not to reference/hold earlier lazy sequence
;; items for too long. This allows earlier items to be cleared
;; from memory and prevents OOM (OutOfMemoryError).

(range 5 10)
;;=> (5 6 7 8 9)

;; WARNING !!!  Don't evaluate this from your repl as it will hang/crash !!
;; Evaluating this from your repl, will cause the repl to try and evaluate
;; an infinite lazy sequence all at once.
(range)
;;=> (0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 ...)

(take 10 (range))
;;=> (0 1 2 3 4 5 6 7 8 9)

;;
;; ### Regular expression patterns
;;
;; Clojure also supports regular expression
;; patterns as literals which directly map to the
;; `java.util.Pattern` and offers a number of
;; functions to match, find and extract patterns.
;; For example: `re-find` and `re-seq` to find
;; respectively the first or all occurrences of a
;; matching pattern. With `re-pattern` you can
;; programmatically create a function out of a
;; string.
;;

#"[\w\d.-]+@[\w\d-.]+\.[\w]+"
;;=> #"[\w\d.-]+@[\w\d-.]+\.[\w]+"

(type #"[\w\d.-]+@[\w\d-.]+\.[\w]+")
;;=> java.util.regex.Pattern

(re-find #"[0-9]+" "only 123 numbers")
;;=> "123"

(re-find #"[0-9]+" "no numbers")
;;=> nil

(re-find #"[\w\d.-]+@[\w\d-.]+\.[\w]+"
         "bob.smith@acme.org")
;;=> "bob.smith@acme.org"

(if (re-find #"^[\w\d.-]+@[\w\d-.]+\.[\w]+$"
             "bob.smith@acme.org")
  "it's an email"
  "it's not an email")
;;=> "it's an email"

(re-seq #"[0-9]+" "25, 43, 54, 12, 15, 65")
;;=> ("25" "43" "54" "12" "15" "65")

(re-pattern "[0-9]{1,3}(\\.[0-9]{1,3}){3}")
;;=> #"[0-9]{1,3}(\.[0-9]{1,3}){3}"

(re-find
 (re-pattern "[0-9]{1,3}(\\.[0-9]{1,3}){3}")
 "my IP is: 192.168.0.12")
;;=> ["192.168.0.12" ".12"]

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
;; Everything we have seen so far were pure
;; values, as such they were all evaluating to
;; themselves.  Like `42` is just `42`, the
;; following vector `[:a "hello" 9]` just
;; evaluates to itself, it is just a value.
;; Symbols, however, during the evaluation
;; are replaced with the current value of var
;; they are pointing to. If you try to evaluate
;; a var which is undefined you will get an error.
;;
;; Symbols are organised into namespaces.  We will
;; not explore much about namespaces here, but it
;; will suffice to know that symbols belong to a
;; namespace in which they assume a particular
;; value, and you can have the same symbol name in
;; different namesapce pointing to different
;; values.
;;
;; In Clojure symbols start with a letter, and can contain
;; letters, numbers, dashes, some punctuation marks and other
;; characters. Basically anything which doesn't belong in the
;; Clojure syntax (following characters aren't accepted in
;; symbols name `@#,/.[]{}()`) anything else is a valid
;; symbol.
;;
;; You can create symbols by quoting a word with
;; the `quote` function or the single quote
;; character, you can use the function `symbol`,
;; but most commonly you will use symbols in place
;; of vars and locals which are define with the
;; special forms `def` and `let` respectively. A
;; symbol name which is NOT quoted will be
;; resolved to the current value of the associated
;; var.
;;
;; As we will see in the following examples symbols
;; are un-typed and can refer to any Clojure value,
;; including `nil`
;;

(symbol "username")
;;=> username

(type (symbol "username"))
;;=> clojure.lang.Symbol

(type 'username)
;;=> clojure.lang.Symbol

(def username "bruno1")
;;=> #'learn-clojure.basics/username

username
;;=> "bruno1"

age ;; undefined var produces error
;;=> Unable to resolve symbol: age in this context

(def age 21)
;;=> #'learn-clojure.basics/age

age
;;=> 21

(type 'age)
;;=> clojure.lang.Symbol

(type age)
;;=> java.lang.Long

(def user {:username "bruno1"
           :score    12345
           :level    32
           :achievements #{:fast-run :precision10
                           :strategy}})
;;=> #'learn-clojure.basics/user

user
;;=> {:username "bruno1", :score 12345, :level 32, :achievements #{:precision10 :strategy :fast-run}}

(def user nil)
;;=> #'learn-clojure.basics/user

user
;;=> nil


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
;;=> #'learn-clojure.basics/colours

(def new-colours (cons :black colours))
;;=> #'learn-clojure.basics/new-colours

new-colours
;;=> (:black :red :green :blue)

colours
;;=> (:red :green :blue)

(def user {:username "bruno1"
           :score    12345
           :level    32})
;;=> #'learn-clojure.basics/user

(def user' (assoc user :level 33))
;;=> #'learn-clojure.basics/user'

user'
;;=> {:username "bruno1", :score 12345, :level 33}

user
;;=> {:username "bruno1", :score 12345, :level 32}

;;
;; ### Functions
;;
;; So far we have seen how to represent data in
;; our system, now we will see how to make sense
;; of this data and how to extract/process/transform it.
;; The way we express this in
;; Clojure is via functions.
;;
;;
;; #### Purity
;;
;; While Clojure doesn't enforce purity at
;; compiler level, it certainly promotes
;; pure-functions.  Pure functions are those
;; functions in which the processing doesn't use
;; or produce any side effect, which means it will
;; use only the input parameters to compute the
;; resulting value, and given the same parameters
;; it will always produce the same result.
;;
;; When a function given a certain input, always
;; produces the same output it is said to be
;; __referentially transparent__, because the
;; function call itself can be replaced with
;; its value without altering the rest of the
;; expression.
;;
;; Pure functions are important because
;; they are incredibly easy to test as
;; they don't depend on external state.
;;
;; Here are two examples: the first is the function `+`
;; which we have already seen, and the second is the
;; function `rand-int` which produce a random
;; integer number between `0` and the given
;; integer.  While the first is pure because given
;; the same input parameters it will always produce the
;; same output, the second one given the same
;; input returns a different value every time.
;;

(+ 1 2 3)
;;=> 6

(rand-int 100)
;;=> 18

(rand-int 100)
;;=> 85

(+ 1 2 (+ 1 1 1)) ;; (+ 1 1 1) is referentially transparent
;;=> 6

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
;;

((fn [n] (+ n 1)) 10)
;;=> 11

((fn [n] (+ n 1)) -42)
;;=> -41

;;
;; Since defining functions is very common, there
;; is a shorthand to the idiom
;; `(def funciton-name (fn [parameter list] (expression)))`
;; via the `defn` form which just combines the `def` and
;; `fn` forms.  So we can redefine the previous
;; function in the following way:
;;

(defn plus-one [n]
  (+ n 1))
;;=> #'learn-clojure.basics/plus-one

(plus-one 1)
;;=> 2

;;
;; It is good practice to include a short description (called `docstring`)
;; in the function.
;;

(defn plus-one
  "Returns a number which is one greater than the given `n`."
  [n]
  (+ n 1))
;;=> #'learn-clojure.basics/plus-one

;;
;; **NOTE:** that Clojure core already contains
;; such a function and it is called `inc`, while the
;; function `dec` decrements by 1 the given value.
;;

(inc 10)
;;=> 11


;;
;; In the following example we see how to create
;; functions with multiple parameters.
;; Let's assume we have to create
;; a function which create a corporate email
;; address for its employee. Oftentimes
;; this type of email follows a very specific pattern
;; In this case we will take the first letter of
;; the name followed by the lastname then `@` the company
;; domain.
;;

(defn email-address [firstname lastname domain]
  (clojure.string/lower-case (str (first firstname) lastname "@" domain)))
;;=> #'learn-clojure.basics/email-address

(email-address "John" "Smith" "acme.org")
;;=> "jsmith@acme.org"

(email-address "Walter" "White" "breakingbad.org")
;;=> "wwhite@breakingbad.org"

;;
;; #### Function with multi-arities
;;
;; So far we've seen how to create functions
;; which accept a fix number of parameters.
;; In Clojure is possible to create functions
;; which accept different set of 'arities'.
;;

(defn simple-greet
  ([]
   (simple-greet "World"))
  ([name]
   (str "Hello " name "!")))
;;=> #'learn-clojure.basics/simple-greet

(simple-greet)
;;=> "Hello World!"

(simple-greet "Fred")
;;=> "Hello Fred!"


(defn greet
  ([]
   "Hey, Stranger!")
  ([name]
   (str "Hello " name))
  ([firstname lastname]
   (str "Hi, you must be: " lastname ", " firstname " " lastname))
  ([title firstname lastname]
   (str "Hello " title " " firstname " " lastname)))
;;=> #'learn-clojure.basics/greet

(greet)
;;=> "Hey, Stranger!"

(greet "James")
;;=> "Hello James"

(greet "James" "Bond")
;;=> "Hi, you must be: Bond, James Bond"

(greet "Dr" "John H." "Watson")
;;=> "Hello Dr John H. Watson"


;;
;; It is also possible to create functions
;; which have any number of parameters.
;; these are called `variadic functions`.
;;

(defn de-dup [& names]
  (seq (set names)))
;;=> #'learn-clojure.basics/de-dup

(de-dup "John" "Fred" "Lara" "John" "John" "Susan")
;;=> ("Susan" "Fred" "John" "Lara")

(defn short-name [firstname & names]
  (str firstname " " (last names)))
;;=> #'learn-clojure.basics/short-name

(short-name "Maria" "Teresa" "Jiulia" "Ramírez de Arroyo" "García")
;;=> "Maria García"

;;
;; #### High-order functions
;;
;; In Clojure functions are reified contructs,
;; therefore we can threat them as normal
;; values. As such functions can be passed as
;; parameters of function or returned as result of
;; function call.
;;

(defn is-commutative? [op a b]
  (= (op a b) (op b a)))
;;=> #'learn-clojure.basics/is-commutative?

(is-commutative? + 3 7)
;;=> true

(is-commutative? / 3 7)
;;=> false


(defn multiplier [m]
  (fn [n]
    (* n m)))
;;=> #'learn-clojure.basics/multiplier

(def doubler (multiplier 2))
;;=> #'learn-clojure.basics/doubler

(doubler 5)
;;=> 10

(doubler 10)
;;=> 20

(def mult-10x (multiplier 10))
;;=> #'learn-clojure.basics/mult-10x

(mult-10x 35)
;;=> 350

;;
;; #### Anonymous functions or lambda functions
;;
;; Oftentimes you want to create a function for a
;; specific task in a local context. Such
;; functions don't have any reason to have a global
;; name as they are meaningful only in that
;; specific context, in this case you can create
;; anonymous functions (also called lambda
;; function) and Clojure has some support to make
;; this easier.  We already seen an example of
;; an anonymous function with our very first function
;; example.
;;

(fn [n] (+ n 1)) ;;Evaluates to an object/value. In Clojure, functions are values
;;=> #function[learn-clojure.basics/eval20002/fn--20003]

((fn [n] (+ n 1)) 10)
;;=> 11

;;
;; here the function we built hasn't got a name.
;; We then used a `def` form to give it the
;; `plus-one` name.
;; This anonymous function could also be written
;; in the following way.

#(+ % 1)
;;=> #function[learn-clojure.basics/eval20028/fn--20029]

(#(+ % 1) 10)
;;=> 11

;;
;; In this function the symbol `%` replace the argument
;; If you have more than one parameter you can denote them as
;; `%1` (or `%`), `%2`, `%3`, `%4` ...
;;
;; for example in our `is-commutative?` function we expect
;; and operation which accept two arguments:

(is-commutative? #(+ %1 %2) 9 8)
;;=> true

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
;; Like in our `multiplier` function example,
;; the returned function is closing over the
;; value `m` which is not in its parameter list
;; but it is a parameter of the parent context
;; the `multiplier` fn. While `n` is a normal parameter
;; `m` is the value we are "closing over"
;; providing a context for that function.

(defn multiplier [m]
  (fn [n]
    (* n m)))
;;=> #'learn-clojure.basics/multiplier

;;
;; Let's see another example. Here
;; we want to create a function which
;; takes a number and return a logical value
;; representing whether the number
;; is between two limits (limits included).
;; For this purpose we can use the function `>=`
;; which returns whether a number is greater or equal
;; then the other one.
;;
;; Other similar functions are `>`, `<`, `<=`, `=` and `not=`.
;;

(>= 10 3) ;; like 10 >= 3
;;=> true

(>= 3 10)
;;=> false

(>= 6 6)
;;=> true

(>= 6 5 2)
;;=> true


(defn limit-checker [min max]
  (fn [n]
    (>= max n min)))
;;=> #'learn-clojure.basics/limit-checker

(def legal-value (limit-checker 5 10))
;;=> #'learn-clojure.basics/legal-value

(legal-value 1)
;;=> false

(legal-value 7)
;;=> true

(legal-value 10)
;;=> true

(legal-value 11)
;;=> false

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
;;=> #'learn-clojure.basics/sum1

(sum1 1)
;;=> 1

(sum1 3)
;;=> 6

(sum1 10)
;;=> 55

;;
;; This type of recursion is called mundane
;; recursion and every new call it allocates one
;; new frame on the stack so if you run this with
;; high enough numbers it will blow your stack.
;;

(sum1 10000)
;;=> StackOverflowError

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
;;=> 55

(sum2 10000)
;;=> 50005000

(sum2 1000000)
;;=> 500000500000

(sum2 100000000)
;;=> 5000000050000000

;;
;; As you can see the function can recur much
;; more without exploding this is because
;; it doesn't consume stack.
;; The tail recursion can be used only when
;; when the recursion point is in the tail
;; position (a return position).
;;
;; Now in `sum1` and `sum2` we had to add
;; another function arity just to keep track
;; of the `accumulator`. This is very
;; common in recursion, while recurring
;; you have to keep track of some
;; accumulated value, therefore Clojure
;; makes it simpler by providing another
;; form called `loop` which plays well
;; with `recur`. In Clojure you'll often
;; hear about `loop/recur` construct.
;;
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
;;=> #'learn-clojure.basics/sum3

(sum3 10)
;;=> 55

;; Let's see another example with the Fibonacci
;; sequence. Let's start with the mundane
;; recursion.

(defn fibonacci1
  [n]
  (if (< n 2)
    1
    ;; else
    (+ (fibonacci1 (- n 1))
       (fibonacci1 (- n 2)))))
;;=> #'learn-clojure.basics/fibonacci1

(fibonacci1 1)
;;=> 1

(fibonacci1 10)
;;=> 89


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
;;=> "Elapsed time: 1806.753129 msecs"
;;=> 14930352

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
;;=> #'learn-clojure.basics/fibonacci2

(fibonacci2 10)
;;=> 89

(time
 (fibonacci2 35))
;;=> "Elapsed time: 0.04467 msecs"
;;=> 14930352

(time
 (fibonacci2 1000))
;;=> "Elapsed time: 1.145227 msecs"
;;=> 70330367711422815821835254877183549770181269836358732742604905087154537118196933579742249494562611733487750449241765991088186363265450223647106012053374121273867339111198139373125598767690091902245245323403501N


;;
;; #### Function composition and partial functions
;;
;; We seen earlier that we functions such as `first`,
;; `second`, `last` and `rest` to access respectively
;; the first item of the sequence, the second one,
;; the last one and the tail of the sequence.
;; If it happens that we are working with lots 5 items
;; sequences we have the tools to get all but the third
;; and the forth item. If you are doing a lot of them
;; you'll probably extract into two functions as follow:

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

;; But there is another way.
;; If, like in this case, the output of a function
;; gets passed directly into the next one
;; as a simple pipeline of functions
;; then you can just use the `comp` function.
;;
;;      (comp f1 f2 f3 ... fn)

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
;; Now let's say we want to create a function which
;; given a number perform `almost-twice` two times.
;;

(def almost-twice-twice (comp almost-twice almost-twice))

(almost-twice-twice 5)
;;=> 17

(almost-twice-twice 10)
;;=> 37

;; Another way we could have wrote the `doubler`
;; function is by using the partial application
;; of the function `*`. In Clojure this
;; is achieved via the function `partial`.
;;
;;      (partial f arg1 ... argn)
;;

(def doubler (partial * 2))

(doubler 5)
;;=> 10

;; what happens here is that the `partial`
;; function return a function which
;; calls `*` with the parameters of the partial
;; and the parameter of the final call all in one call.
;;
;; Another nice example is using the function `format`
;; which takes a format-string and a bunch of arguments
;; and formats the string accordingly. This is very similar
;; to the C `printf` function however Clojure uses the
;; Java `String.format` implementation.
;; So we can use this to produce a string which contains
;; a zero-padded formatted version of the given number.
;;

(def pad0 (partial format "%013d"))

(pad0 43)
;;=> "0000000000043"

(pad0 2346765847)
;;=> "0002346765847"


(def item-location (partial format "Section: %d, Row %d, Shelve: %s"))

(item-location 3 12 "F")
;;=> "Section: 3, Row 12, Shelve: F"


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
;; We will use `ns` which create a namespace if not present
;; and switch to it, and `in-ns` just changes the current namespace.
;; we will see how to loads namespaces we need with our processing
;; with `require` and how vars are globally accessible.


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

(in-ns 'user.test.one)
;;=> #namespace[user.test.one]

my-name
;;=> "john"

(ns user.test.one)
;;=> nil

(def my-name (clojure.string/upper-case "john"))
;;=> #'user.test.one/my-name

my-name
;;=> "JOHN"

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

(ns user.test.one
  (:require [clojure.string :refer [upper-case]])
  (:require [user.test.two :as two]))
;;=> nil

(def my-name (upper-case two/my-name))
;;=> #'user.test.one/my-name

my-name
;;=> "JULIE"

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

(defn sum
  [v1 v2]
  (+ v1 v2))

;; In this example `v1` and `v2` are only accessible
;; inside the function. Outside might be undefined
;; or have a different value:


(def v1 "hello")
(def v2 "world")

(sum 10 25)
;;=> 35

v1
;;=> "hello"

v2
;;=> "world"

;;
;; There is another way to create local binding which are valid
;; only inside the s-expr block, using `let`.
;; With the let form you can create local variable which
;; are visible only inside the block.

(let [v1 23
      v2 45]
  ;; inside this block v1 v2 have the values 23 and 45
  (+ v1 v2))
;;=> 68

;;
;; outside the block v1 and v2 are resolved in the
;; parent scope which in this case is the
;; namespace/global You can even nest `let`
;; bindings and use them inside functions.
;; Here we use `println` to print to the standard output
;; a message

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
;; ### Destructuring
;;
;; Destructuring is a simple, yet powerful feature
;; of Clojure. There are several ways in which you
;; can leverage destructuring to make your code
;; cleaner, with less repetitions, and less
;; bug-prone code.  Destructuring is a way to
;; unpack a collection into values and bind them
;; to locals.  It takes a bit of exercise to make
;; the eye used to read destructuring forms, but
;; once done, the code appears much cleaner.  I
;; won't cover the destructuring here, however I
;; wrote a detailed post about the topic which you
;; can find here: [The complete guide to Clojure
;; destructuring](http://blog.brunobonacci.com/2014/11/16/clojure-complete-guide-to-destructuring/)
;;
;;
;; ### Flow control
;;
;; We briefly introduced `if` for flow control,
;; which is the basic form on top of which all the
;; others are based upon.  Moreover there are more
;; options for flow control in Clojure which we will
;; see i.e `if`,`not`, `and`, `or`, `if-not`, `when`,
;; `when-not`, `cond` and `case`.
;;
;;
;;     (if condition
;;         then
;;         else)
;;
;; the `condition` doesn't have to be a boolean
;; expression necessarily as, in Clojure, anything
;; is considered to be `true` except `false` and `nil`
;; As you would expect if the `condition` is evaluated
;; to be true the `then` expression is evaluated,
;; otherwise the `else` expression is evaluated.
;; The overall result will be determined by the
;; result of the expression which is evaluated.
;;

(if (= 1 1)
  "this is true"
  "this is false")
;;=> "this is true"

(if (not (= 1 1))
  "this is true"
  "this is false")
;;=> "this is false"

;;
;; Some times you don't have `else` clause,
;; so you can omit it.

(if (not= 1 0)
  (println "that's odd"))
;;=> that's odd
;;=> nil

;;
;; when you have `if` and `not` together you can
;; combine them in `if-not`

(if-not (= 1 0)
  (println "that's odd"))
;;=> that's odd
;;=> nil

;; But when there is no else expression
;; a more idiomatic way to write it in Clojure
;; would be to use the form `when`, and similarly
;; when you have a negation in your condition
;; you can use `when-not`.

(when (not= 1 0)
  (println "that's odd"))
;;=> that's odd
;;=> nil

(when-not (= 1 0)
  (println "that's odd"))
;;=> that's odd
;;=> nil

;;
;; `when` accepts more than one expression
;; and the result of the overall expression
;; is the result of last form, or `nil`
;; if the condition is false.

(when true
  1
  2
  3
  4)
;;=> 4

;;
;; However `if` accepts one form for the then, and
;; another form for the `else` when given. If you
;; have to invoke several functions perhaps with
;; side-effect, then you have to use the `do`
;; form.

(do
  1
  2
  3
  4)
;;=> 4


(if true
  (do
    (println "this is executed when true")
    (println "this one too.")
    (println "the next line is the value returned")
    :ok)
  (do
    (println "this is executed in the else")
    :this-is-else))
;;=> this is executed when true
;;=> this one too.
;;=> the next line is the value returned
;;=> :ok


;;
;; If you have to check the equality to many
;; different values you can use the `case`
;; which is similar to `switch/case` of many
;; languages. In Clojure it looks like this:
;;
;;     (case value
;;        val1  expr1
;;        val2  expr2
;;        val3  expr3
;;        default-exp)
;;

(let [order-status :completed]
  (case order-status
    :new         "We have received your order, thanks."
    :processing  "We are processing your order"
    :ready       "We are processing your order"
    :shipped     "Your order is on it's way"
    :completed   "This order has been already delivered"
    "This order is not found"))
;;=> "This order has been already delivered"

;;
;; If you have multiple value with the same
;; expression you can group them in a list.
;;

(let [order-status :ready]
  (case order-status
    :new         "We have received your order, thanks."
    (:processing :ready)   "We are processing your order"
    :shipped     "Your order is on it's way"
    :completed   "This order has been already delivered"
    "This order is not found"))
;;=> "We are processing your order"


;;
;; Another very popular conditional form is
;; `cond`, this is used in place of their
;; `if/else-if/else-if/else` of other languages.
;;
;;     (cond
;;        condition1 expr1
;;        condition2 expr2
;;        condition3 expr3
;;        :else default-expr)
;;

(let [age 21]
  (cond
    (< age 16) "You are too young to drive"
    (<= 16 age 18) "You can start your driving lessons"
    (>= 100 age 18) "You can drive only if you have got a license"
    :else "Maybe you should let someone else driving."))
;;=> "You can drive only if you have got a license"


;;
;; If you have complicated conditions you might
;; have to combine the conditions logically with `and`,
;; `or` and `not`. We've already seen `not` which
;; negates the given condition, while `and` and
;; `or` work as you would expect.
;;
;;     (and
;;       condition1
;;       condition2
;;       condition3)
;;
;; the value of the entire expression is the value
;; of the last condition. If a condition is found
;; to be falsey (`false` or `nil`) the
;; evaluation is interrupted and the whole expression
;; will have the value of last evaluated expression.
;;

(and true true true)
;;=> true

(and 1 2 3 4)
;;=> 4

(and 1 2 nil 4 5)
;;=> nil

;;
;; Similarly `or` accepts multiple conditions,
;; and they are evaluated in the given order,
;; and the first condition which is found to
;; be true will stop the evaluation
;; and return its value as the value of the
;; the whole expression.

(or false false nil true)
;;=> true

(or false 1 nil 3)
;;=> 1

;;
;; `or` is often used to provide default
;; values to parameters function via destructuring
;; however it can be used in normal code as well.
;;

(defn connection-url [config-map resource]
  (let [protocol (or (:protocol config-map) "http")
        hostname (or (:hostname config-map) "localhost")
        port     (or (:port     config-map) 8080)]
    (str protocol "://" hostname ":" port resource )))

(connection-url {} "/users")
;;=> "http://localhost:8080/users"

;;
;; Obviously you can combine `and`, `or` and `not`
;; to create arbitrary complex conditions.
;;
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

;;=> (["Lorem" "ipsum" "dolor" "sit" "amet" "consectetur" "adipiscing" "elit"] ["Duis" "vel" "ante" "est"] ["Pellentesque" "habitant" "morbi" "tristique"] ["senectus" "et" "netus" "et" "malesuada" "fames" "ac" "turpis" "egestas"])

;; application of the split function to a single sentence
;; produces a list of words. Consequently the application
;; of the function to all sentences produces a list of lists.
;; If we rather have a single list with all the words
;; we then need to concatenate all the sub-lists into one.
;; To do so Clojure core has the `concat` function which
;; just concatenates multiple lists into one.

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
;; function returns a "thruthy" value.  Predicate
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
;; it just return the value.
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
;; sequence of the element in the given collection.
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
;; to perform grouping on your data.
;; `group-by` accepts a function and a collection
;; and it will apply the given function
;; to all items in the collections and groups
;; those which have the same result into
;; the same key. It returns a map where
;; the key is the group-value, and
;; the value of the map is a list of items
;; which belong to that group.

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
;; The `step` parameters tells the function
;; how many item has to move forward after every chunk.
;; if not give `step` is equal to `n`

(partition 3 1 (range 11))
;;=> ((0 1 2) (1 2 3) (2 3 4) (3 4 5) (4 5 6) (5 6 7) (6 7 8) (7 8 9) (8 9 10))

(partition 3 5 (range 11))
;;=> ((0 1 2) (5 6 7))

;;
;; #### The function: `into`
;;
;; `into` is used to create a new collection of a given
;; type with all items from another collection "into" it.
;; Items are conjoined using `conj`
;; It is often used to change the type of a map,
;; or to build a map out of key/value pairs.
;;
;;      (into dest source)
;;

(into [] '(0 1 2 3 4 5 6 7 8 9))
;;=> [0 1 2 3 4 5 6 7 8 9]


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
;; _Oftentimes while working with network
;; requests, you might want to retry a given
;; request a number of times before giving up. In
;; such cases there is a library called
;; [safely](https://github.com/BrunoBonacci/safely)
;; which might be handy._
;;
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
;; [A "dead simple" introduction to Clojure macros.](http://blog.brunobonacci.com/2015/04/19/dead-simple-introduction-to-clojure-macros/)
;;
