(ns learn-clojure.basics)

;;
;; # Clojure basics
;;
;; I will try to introduce concepts gradually without assuming prior
;; knowledge of Clojure (or any other LISP dialect).  However I will
;; assume that you are already an experienced developer in any other
;; popular language such as Java, C/C++, Python or Javascript.
;; General programming concepts such as function, parameters,
;; recursion, objects and common data-structure will be assumed to be
;; already known.
;;
;;
;; # The function call.
;;
;; The first concept I will introduce is how to do a function call.
;; We will see more about functions later, but for the moment
;; I want to make sure that you will understand the next few examples.
;; Let's start to make some comparison on how to call a method or function
;; in a few different languages
;;
;;     // java and C++
;;     object.method(arg1, arg2, arg3);
;;
;;     // C
;;     function(struct, arg1, arg2, arg3);
;;
;;     ;; Clojure
;;     (function object arg1 arg2 arg3)
;;
;;
;; As you can see in Clojure the brackets surround the function and
;; all its arguments.  In object oriented languages such as Java and
;; C++ the object comes before the method name or function name. In C
;; and Clojure the function comes first, then followed by the target
;; object.  <i>For the sake of the example I will omit the required
;; package imports.</i>
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
;; There is only a function to turn a single character into its
;; lowercase form, that's why there is a loop. However the `tolower(*c)`
;; is function call example.
;;
