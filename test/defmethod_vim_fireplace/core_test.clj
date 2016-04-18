(ns defmethod-vim-fireplace.core-test
  (:require [clojure.test :as ct :refer :all]
            [defmethod-vim-fireplace.core :refer :all]))

(defmethod ct/report :begin-test-var [m]
  (println "starting test: " m))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))
