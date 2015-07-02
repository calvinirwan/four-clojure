(ns four-clojure.part13)
;;problem 121
(defn p121
  [f]
  (fn [m]
    (do (def a ('a m))
        (def b ('b m)))
    (eval f)))

((__ '(/ a b))
      '{b 8 a 16})
