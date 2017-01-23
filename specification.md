# メソッド名の取り決め

## keijiban

### クラス Keijiban

| メソッド名 | 引数 | 返却値 |
| :-- | :-- | :-- |
| getMessages | なし | PostFormの配列 |
| postMessage | 投稿フォーム(PostForm, timeの値は不要) | true/false |

#### PostForm

```
{ 
  name: <投稿者名(String)>,
  message: <本文(String)>,
  time: <投稿日時(Date)>
}
```


## ranking

### クラス Ranking

| メソッド名 | 引数 | 返却値 |
| :-- | :-- | :-- |
| getRanking | ゲーム名(String) | RecordFormの配列 |
| sendScore | スコア(RecordForm, rankの値は不要) | true/false |

#### RecordForm

```
{
  name: <名前(String)>,
  score: <点数(int)>,
  rank: <順位(int)>
}
```


## zaikokanri

### Zaiko

| メソッド名 | 引数 | 返却値 |
| :-- | :-- | :-- |
| getItemList | なし | ItemFormの配列 |
| receiveItem | ItemForm | true/false |
| issueItem | ItemForm | 出庫可否(true/false) |

注釈: issueItemは商品の出庫を意味します。もし、在庫数よりも多い数量の出庫依頼が出たときは`false`が返却されます

### ItemForm

```
{
  name: <商品名(String)>,
  amount: <個数(int)>
}
```
