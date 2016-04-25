(defproject learn-clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [samsara/samsara-utils "0.5.5.0"]]
  :profiles {:dev {:dependencies [[samsara/samsara-utils "0.5.5.0"]]
                   :plugins [[lein-marginalia "0.9.0"]]}}
  )
