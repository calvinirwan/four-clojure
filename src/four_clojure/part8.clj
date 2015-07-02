(ns four-clojure.part8)
;;problem 73


(defn p73
  [coll]
  (let [hor (map (fn [x] (map #(list %1 %2) (cycle [x]) (range 3))) (range 3))
        ver (map (fn [x] (map #(list %1 %2) (range 3) (cycle [x]))) (range 3))
        dia1 (map #(list %1 %2) (range 3) (range 3))
        dia2 (map #(list %1 %2) (range 3) (reverse (range 3)))
        all (conj (concat hor ver) dia1 dia2)]
    (first
     (keep (fn [l]
             (let [end (map #(get-in coll %) l)]
               (if (apply = end)
                 (if (or (= (first end) :x) (= (first end) :o))
                   (first end)
                   nil)))) all))))

;;problem 75
(defn gcd
  [n m]
  (if (zero? n) 
    m 
    (recur (rem m n) n)))

(defn p75
  [x]
  (if (= x 1)
    1
    (count (filter #(= 1 ((fn 
                            [n m]
                            (if (zero? n) 
                              m 
                              (recur (rem m n) n))) x %)) (range 1 x)))))

;;problem 78
(defn tiger
  [x]
  (if (< x 0)
    "tiger"
    #(tiger (do (println :x x) (dec x) (- x 2)))))

(defn tram
  [f & args]
  (apply f args))

;;problem 79
(defn p79
  [x y coll]
  (if (get-in coll [(inc x) y])
    (+ (get-in coll [x y])
       (min (p79 (inc x) y coll)
            (p79 (inc x) (inc y) coll)))
    (get-in coll [x y])))

#((fn p79
  [x y coll]
  (if (get-in coll [(inc x) y])
    (+ (get-in coll [x y])
       (min (p79 (inc x) y coll)
            (p79 (inc x) (inc y) coll)))
    (get-in coll [x y]))) 0 0 (vec %))
