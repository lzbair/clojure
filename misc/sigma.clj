(defn sigma [a b T N] (if (> a b) 0 (+ (T a) (sigma (N a) b T N))))
;usage:  (sigma 0 3 (fn [x] (* x x)) (fn [x] (+ x 1)))  ==> 0 + 1 + 4 + 9 = 14
