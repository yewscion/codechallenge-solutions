(define-module (codechallenges aoc2021 day-one sonar-sweep)
  :use-module (ice-9 textual-ports)
  :use-module (srfi srfi-1)
  :export (file-of-numbers->list
           delta-list
           count-match
           value-list->block-list)
  :version (1 0 0))
;;; Library
(define (file-of-numbers->list filename)
  "Takes a string which should reference a file on disk with numbers separated
by newlines and converts it to a list of numbers.

FILENAME: The name of the file that should be loaded."
  (map string->number
       (string-split
        (call-with-input-file filename get-string-all)
        #\newline)))

(define (delta-list input)
  "Takes a list of numbers, and returns a list of symbols, with 'increase
indicating a positive delta, 'decrease indicating a negative delta.

INPUT: A list of numbers.
LIST: A list of symbols as outlined above."
  (let ((previous-value (car input))
        (current-value (cadr input)))
    (cond
     ((equal? current-value #f) '())
     ((< previous-value current-value)
      (append '(increase) (delta-list (cdr input))))
     ((> previous-value current-value)
      (append '(decrease) (delta-list (cdr input))))
     (else (append '(nil) (delta-list (cdr input)))))))

(define (count-match list match)
  "Takes a list of symbols and a single symbol, and counts how many times that
symbol appears in the list.

LIST: A list of symbols.
MATCH: The symbol to match in the list."
  (length
   (partition
    (lambda (x)
      (equal? x
              match))
    list)))

(define* (value-list->block-list input #:optional (blocksize 3))
  "Takes a list of values and creates a list of blocks by summing a number of
the elements using a sliding window.

LIST: The list of values.
BLOCKSIZE: The number of elements in each sliding window."
  (cond ((>= blocksize (length input)) (list #f))
        (else (append
               (list (fold + 0 (take input blocksize)))
               (value-list->block-list (cdr input)
                                       blocksize)))))
