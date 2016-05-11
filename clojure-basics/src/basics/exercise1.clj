(ns basics.exercise1
  (:require [midje.sweet :refer [fact]])
  (:require [clojure.string :as str]))


;;
;; For this exercise we will need some supporting data
;; Please download the entire Shakespeare opera
;; from the Gutenberg website
;; https://www.gutenberg.org/cache/epub/100/pg100.txt
;; and place the file in your project folder under
;; ./data/shakespeare.txt
;;
;; To objective of this exercise if to find
;; the top 10 anagram sequences in Shakespeare's
;; opera.
;;
;; An anagram sequence is a group of words which are
;; made by rearranging the letters (case-insensitive).
;; For example the words:
;; "Team", "meat" and "Mate" are all anagram of each other
;; and can belong to the same sequence as the use the same letters.
;; While "tar" and "rat" belong to another sequence of anagrams.
;;
;; Write a function which takes the Shakespeare opera as input
;; which you downloaded as text "./data/shakespeare.txt"
;; and return a sequence of the longest 10 sequences,
;; of anagrams without duplicates.


(defn top-anagrams
  [text]
  ;; please complete the function
  )


;;
;; Here we are writing a test using the Midje library.
;; https://github.com/marick/Midje/wiki/A-tutorial-introduction
;;
;; Which provides form called `fact` which takes
;; and expression and it's expected result
;; in the form of:
;;
;;      (fact "description"
;;          (+ 1 1) => 2)
;;
;;
(fact "Anagrams are extract sorted by the longest chain"

      (let [text "My Team's mate eats a lot of meat.
                  While the rat on the tar is causing
                  trouble to the people laying the new tar
                  on the road."]

        (top-anagrams text)) => [["meat" "mate" "team"]
                                 ["rat" "tar"]])



;; get the top 10 anagrams chains with
;; (top-anagrams (slurp "./data/shakespeare.txt"))
