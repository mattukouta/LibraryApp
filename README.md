# LibraryApp [![Build Status](https://app.bitrise.io/app/5710371c1ac541d2/status.svg?token=Z7Wl5-qnR9QlpIC1EJfHOw&branch=develop)](https://app.bitrise.io/app/5710371c1ac541d2)
- 個人的に「ライブラリに触れられていないなと感じたので，試したいものとかを実装してみよう」がテーマです．
- 随時更新していきます。

## 実装済み機能
### API
WikipediaのAPI(XML)を使って，キーワードで検索した結果を表示しています．  
表示結果のリストをタップするとそのTitleのページをブラウザで開きます ．
※ 検索結果がないとアプリ終了してしまいます。(どうにかするつもりですが...)

## 使用CI
### Bitrise
Bitrise自体に慣れたいというのと大学の某プロジェクトの試用で使っています．
現状では，PRをトリガーにして，ktlintを回して，その結果をslackに通知と簡単なものになっています．

## Linter
### [ktlint](https://github.com/pinterest/ktlint)を導入しています
現状では，デフォルトのktlintルールになっています．
せっかくAndroid StudioのCode Styleを自分好みにしたので，今後独自ルールを加えたいなと思っています（調べてみてもだいぶ面倒な印象をうけました）．
