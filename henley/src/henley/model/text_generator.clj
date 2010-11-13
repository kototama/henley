(ns henley.model.text-generator
  (:use clojure.contrib.def
        clojure.contrib.pprint
        [clojure.contrib.duck-streams :only (read-lines)])
  (:require [clojure.string :as str]))

(defn- internize [s]
  ;; slow?! : (intern 'acl.ch08.henley (symbol s))
  (symbol s))

(defn read-text [pathname]
  (reduce (fn [stats line]
            (let [words (re-seq #"([a-z'àçéêèëùA-Z]+|[.,;!?])" line)
                  words (map first words)]
              (reduce (fn [stats word]
                        (let [word (internize word)
                              prev (:prev stats)
                              stats (if (get-in stats [prev word])
                                      (update-in stats [prev word] inc)
                                      (assoc-in stats [prev word] 1))]
                          (assoc stats :prev word)))
                      stats words)))
          {:prev (internize ".")}
          (read-lines pathname)))

(defn- random-next [stats prev]
  (let [choices (get stats prev)
        cumulated (reductions + (map second choices))
        i (rand-int (last cumulated))
        cumulated (interleave (map first choices) cumulated)]
    (ffirst (filter
             (fn [[word p]]
               (< i p)) (partition 2 cumulated)))))

(defn generate-text
  [n stats]
  (let [words (drop 1 (iterate #(random-next stats %) (internize ".")))
        text (take n words)]
    (str/join " " text)))
