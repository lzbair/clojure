(defn santa [rules] (if (empty? rules) 0 
                                  (+ (if (= (first rules) '\() 1 -1)
				                     (santa (rest rules)))))
(defn callSanta [rules] (santa (seq rules))) 

;; Usage : (callSanta"(()))((()))") --> -1
