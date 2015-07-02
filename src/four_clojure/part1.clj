(ns four-clojure.part1)
(defn sakaw
  [num lim size]
  (if (>= (+ num lim) size)
    (conj '() (range num size))
    (conj (sakaw (+ num lim) lim size) (range num (+ num lim)))))

