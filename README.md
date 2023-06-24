# View 네이밍 규칙
- Button : btn~
- CheckBox : chk~
- RadioButton : rdo~
- RadioGroup : rdg~
- Layout : layout~
- RecyclerView : list~
- ScrollView : sc~
- ViewPager : pager~

# layout 네이밍 규칙
- Activity : activity~
- Fragment : fragment~
- RecyclerView Items: view~~list
- Other Items: view~~item

# drawable 네이밍 규칙
- 공통 Background > bg_r_~_colorCode (r: round, ex) r_4) (colorCode: ex) ffffff) 
- 개별 Background > bg_~
- Selector Background > sel_bg_~
- Selector > sel_~
- icon > ic_~

# 파일 생성 규칙
- Activity 파일은 ui > activity > '기능명' 패키지에 생성
- Adapter 파일은 ui > activity > '기능명' > adapter 패키지에 생성
- ViewModel 파일은 ui > activity > '기능명' > viewmodel 패키지에 생성
- Fragment 파일은 ui > fragment > '액티비티의 기능명' 패키지에 생성

# Activity, Fragment 규칙
- Activity 파일은 BaseActivity 상속
- Fragment 파일은 BaseFragment 상속
- 코드 순서 : val -> var -> companion object -> override -> fun get~ -> fun set~ -> fun otehr -> fun start~ -> fun request~ -> inner class ###(private -> public)

- Title은 상속한 BaseActivity의 setTitleType(type) getTitleView(resId) 사용
- ProgressBar는 BaseActivity, BaseFragment의 showProgress(boolean) 사용

# 공통 기능
- util > '기능' 패키지에 생성
- 상수는 되도록 util > Constants에 추가
- strings는 기능별로 분리
- colors는 color_~로 네이밍
