(require '[clojure.string :as str])

(defn compute [l w h] (+ 
                        (* (+ (+ (* l w) (* w h)) (* l h)) 2)
						(* l w)))

(defn wrap [dims] (compute 
                    (read-string (nth dims 0)) 
					(read-string (nth dims 1))  
					(read-string (nth dims 2))))

(defn wrap-all [boxes] (if (empty? boxes) 
						   0 
						   (+ 
						     (wrap (sort (str/split (first boxes) #"x"))) 
							 (wrap-all (rest boxes)))))

(defn order [gifts] (wrap-all (str/split gifts #"&")))

;; Usage :  (order "2x3x4&1x1x10") --> 101