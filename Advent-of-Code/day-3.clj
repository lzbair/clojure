(require '[clojure.set :refer [union]])
(require '[clojure.string :as str])
(defn move [pos next] (cond (= next ">") [(+ (first pos) 1) (second pos)] (= next "<") [(- (first pos) 1) (second pos)] (= next "^") [(first pos) (+ (second pos) 1)] (= next "v") [(first pos) (- (second pos) 1)]))
(defn visit [ path] (if (empty? path) nil (union (visit (rest path)) #{(move [0 0] (first path))}))) 
;; Usage:  (visit [0 0] (seq "^>v<") nil) --> 4


(defn visit [start path memory] (if (empty? path) memory (visit (move start (first path)) (rest path) (union memory #{start}))))

(comment
chain.visit()
     .memorize()
	 .sum()
	 
"^v^v" 
       --> (0, 0) 
	   --> mem (0, 0)
	   --> +1 
	   --> (1, 0) 
       --> mem (1. 0)
	   --> +1
	   --> (0, 0) already visited
	   --> (1, 0) already visited
	   --> (0, 0) already visited
	   
--> sum = 2 house
)