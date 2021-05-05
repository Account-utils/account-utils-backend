superHighPrioCategories = [
    '세무조정계산서총괄표',
]

highPrioCategories = [
    '법인세신고서접수증\n',
    '稅務調整計算書\n',
    '법인세과세표준및\n세액조정계산서', #세액조정계산서
    '법인세과세표준및세액신고서\n',
    '지출증명서류수취검토서',
    '유형ㆍ무형자산감가상각비\n조정명세서(정률법)',
    '유형ㆍ무형자산감가상각비\n조정명세서(정액법)',
    '유형자산감가상각비\n조정명세서(정률법)',
    '유형자산감가상각비\n조정명세서(정액법)',
    '무형자산감가상각비\n조정명세서(정률법)',
    '무형자산감가상각비\n조정명세서(정액법)',
    '부속명세서',
]

categories = [
    '원천납부세액명세서(갑)\n',
    '최저한세조정계산서\n',
    '소득구분계산서\n',
    '세액감면(면제)신청서\n',
    '공제감면세액및추가납부세액합계표(갑)\n',
    '공제감면세액및추가납부세액합계표(을)\n',
    '공제감면세액계산서(2)\n',
    '세액공제신청서\n',
    '세액공제조정명세서(3)\n',
    '소득금액조정합계표\n',
    '과목별소득금액조정명세서(1)\n',
    '과목별소득금액조정명세서(2)\n',
    '수입금액조정명세서\n',
    '조정후수입금액명세서\n',
    '부가가치세과세표준증명',#부가가치세과세표준증명
    '감가상각비조정명세서합계표\n',
    '접대비조정명세서(갑)\n',
    '접대비조정명세서(을)\n',
    '세금공과금명세서',
    '선급비용명세서법인명',
    '주요계정명세서(갑)\n',
    '자본금과적립금조정명세서(갑)\n',
    '자본금과적립금조정명세서(을)\n',
    '중소기업등기준검토표\n',
    '주식등변동상황명세서',
    '주주명부',
    '일반연구및인력개발비명세서',
    '해당연도의연구ㆍ인력개발비발생명세',
    '보조금등수취명세서',
    '업무용승용차관련비용명세서',
    '표준대차대조표',
    '표준손익계산서\n',
    '이익잉여금처분(결손금처리)계산서',
    '조정반[지정,변경지정]을신청',
    '전산조직운용명세서',
    '決算報告書',
    '결산자료입력내역',
    '재무상태표\n',
    '손익계산서\n',
    '제조원가명세서\n',
    '공사원가명세서\n',
    '이익잉여금처분계산서\n',
    '합계잔액시산표\n',
    '고정자산관리대장\n',
    # same priority
    '현금명세서\n',
    '보통예금명세서\n',
    '제예금명세서\n',
    '정기예금명세서\n',
    '외상매출금명세서\n',
    '선급금명세서\n',
    '선급비용명세서\n',
    '관계회사주식명세서\n',
    '퇴직연금운용자산명세서\n',
    '출자금명세서\n',
    '임차보증금명세서\n',
    '기타보증금명세서\n',
    '외상매입금명세서\n',
    '미지급금명세서\n',
    '미지급세금명세서\n',
    '장기차입금명세서\n',
    '자본금명세서\n',
    # same priority end
    '「법인세신고도움서비스」\n'
]

categoryToOrder = {
    '': 999,
    '법인세신고서접수증\n' : 0,
    '稅務調整計算書\n' : 1,
    '세무조정계산서총괄표' : 2,
    '법인세과세표준및세액신고서\n' : 3,
    '법인세과세표준및\n세액조정계산서' : 4, #세액조정계산서
    '원천납부세액명세서(갑)\n' : 5,
    '최저한세조정계산서\n' : 6,
    '소득구분계산서\n' : 7,
    '세액감면(면제)신청서\n': 8,
    '공제감면세액및추가납부세액합계표(갑)\n': 9,
    '공제감면세액및추가납부세액합계표(을)\n': 10,
    '공제감면세액계산서(2)\n': 11,
    '세액공제신청서\n': 12,
    '세액공제조정명세서(3)\n': 13,
    '소득금액조정합계표\n': 14,
    '과목별소득금액조정명세서(1)\n': 15,
    '과목별소득금액조정명세서(2)\n': 16,
    '수입금액조정명세서\n': 17,
    '조정후수입금액명세서\n': 18,
    '부가가치세과세표준증명': 19,
    '유형ㆍ무형자산감가상각비\n조정명세서(정률법)': 20,
    '유형ㆍ무형자산감가상각비\n조정명세서(정액법)': 21,
    '유형자산감가상각비\n조정명세서(정률법)': 22,
    '유형자산감가상각비\n조정명세서(정액법)': 23,
    '무형자산감가상각비\n조정명세서(정률법)': 24,
    '무형자산감가상각비\n조정명세서(정액법)': 25,
    '감가상각비조정명세서합계표\n': 26,
    '접대비조정명세서(갑)\n': 27,
    '접대비조정명세서(을)\n': 28,
    '세금공과금명세서': 29,
    '선급비용명세서법인명': 30,
    '주요계정명세서(갑)\n': 31,
    '자본금과적립금조정명세서(갑)\n': 32,
    '자본금과적립금조정명세서(을)\n': 33,
    '중소기업등기준검토표\n': 34,
    '주식등변동상황명세서': 35,
    '주주명부': 36,
    '일반연구및인력개발비명세서': 37,
    '해당연도의연구ㆍ인력개발비발생명세': 38,
    '보조금등수취명세서': 39,
    '지출증명서류수취검토서': 40,
    '업무용승용차관련비용명세서': 41,
    '표준대차대조표': 42,
    '표준손익계산서\n': 43,
    '부속명세서': 44,
    '이익잉여금처분(결손금처리)계산서': 45,
    '조정반[지정,변경지정]을신청': 46,
    '전산조직운용명세서': 47,
    '決算報告書': 48,
    '결산자료입력내역': 49,
    '재무상태표\n': 50,
    '손익계산서\n': 51,
    '제조원가명세서\n': 52,
    '공사원가명세서\n': 53,
    '이익잉여금처분계산서\n': 54,
    '합계잔액시산표\n': 55,
    '고정자산관리대장\n': 56,
    '현금명세서\n': 57,
    '보통예금명세서\n': 58,
    '제예금명세서\n': 59,
    '정기예금명세서\n': 60,
    '외상매출금명세서\n': 61,
    '선급금명세서\n': 62,
    '선급비용명세서\n': 63,
    '관계회사주식명세서\n': 64,
    '퇴직연금운용자산명세서\n': 65,
    '출자금명세서\n': 66,
    '임차보증금명세서\n': 67,
    '기타보증금명세서\n': 68,
    '외상매입금명세서\n': 69,
    '미지급금명세서\n': 70,
    '미지급세금명세서\n': 71,
    '장기차입금명세서\n': 72,
    '자본금명세서\n': 73,
    '「법인세신고도움서비스」\n': 74
}

"""
## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ## ##
"""
import os
import PyPDF2
from io import StringIO
from bs4 import BeautifulSoup
from tika import parser


"""
srcDirectory 내의 모든 pdf 파일을 하나의 pdf 파일로 합친다.(targetFile)
"""
def makeOnePdfFromDirectory2(srcDirectory, targetFile):
    srcFiles = os.listdir(srcDirectory)

    merger = PyPDF2.PdfFileMerger(strict=False)
    for srcFile in srcFiles :
        file = os.path.join(srcDirectory,srcFile)
        if(file.split('.')[1] != 'pdf'):
            continue
        print(srcFile)

        rf = open(file, "rb")
        merger.append(rf)

    output = open(targetFile, 'wb')
    merger.write(output)

def makeOnePdfFromDirectory(srcDirectory, targetFile):
    pdfWriter = PyPDF2.PdfFileWriter()

    srcFiles = os.listdir(srcDirectory)

    with open(targetFile, 'wb') as wf:
        for srcFile in srcFiles :
            file = os.path.join(srcDirectory,srcFile)
            if(file.split('.')[1] != 'pdf'):
                continue
            rf = open(file, "rb")
            print(srcFile)
            pdfReader = PyPDF2.PdfFileReader(rf, strict=False)

            pages = pdfReader.getNumPages()
            for page in range(pages):
                pdfWriter.addPage(pdfReader.getPage(page))
            pdfWriter.write(wf)
            rf.close()


"""
여러 쪽의 pdf 파일을 페이지별로 배열에 담아 리턴
"""
def parsePdf(file):
    pages = []
    data = parser.from_file(file, xmlContent=True)
    xhtml_data = BeautifulSoup(data['content'], features="html.parser")
    for page, content in enumerate(xhtml_data.find_all('div', attrs={'class': 'page'})):
        _buffer = StringIO()
        _buffer.write(str(content))
        parsed_content = parser.from_buffer(_buffer.getvalue())
        pages.append({'id': 'page_'+str(page+1), 'index': page, 'content': parsed_content['content']})
    return pages


"""
페이지에 일치하는 카테고리가 있으면 리턴 (in categories)
"""
def searchCategory(page, categories):
    for category in categories:
        if(page.find(category) != -1):
            return category
    return ''


"""
pdf페이지 배열을 입력받아, 카테고리순으로 정렬하기 위한 index 배열을 리턴
"""
def getSortedPageIndex(pages):
    prev = ''
    for page in pages:
        curr = ''
        pageId = page['id']
        pageString = page['content']
        if pageString:
            pageString = pageString.replace(" ", "")
        else:
            curr = prev
            page["category"] = curr.replace('\n', ' ').strip()
            page["order"] = categoryToOrder[curr]
            continue;

        curr = searchCategory(pageString, superHighPrioCategories)
        if(curr == ''):
            curr = searchCategory(pageString, highPrioCategories)
        if(curr == ''):
            curr = searchCategory(pageString, categories)
        if(curr == ''):
            curr = prev

        prev = curr
        page["category"] = curr.replace('\n', ' ').strip()
        page["order"] = categoryToOrder[curr]

    sortedPages = sorted(pages, key=lambda page : page["order"])
    sortedPageIndex = list(map(lambda page: page["index"], sortedPages))
    return sortedPageIndex


"""
"""
def makeOrderdFile(beforeFile, afterFile, indexList):
    rf = open(beforeFile, "rb")
    pdfReader = PyPDF2.PdfFileReader(rf)

    pdfWriter = PyPDF2.PdfFileWriter()
    for page in indexList:
        pdfWriter.addPage(pdfReader.getPage(page))

    wf = open(afterFile, 'wb')
    pdfWriter.write(wf)
    wf.close()
    rf.close()


"""
[For Test]
"""
def showPage(page, index=-1):
    if(index == -1):
        tkns = page['content'].strip().replace(" ", "").replace("\n\n","").split("\n")
        for i in range(len(tkns)):
            print(str(i) + " : " + tkns[i])
    else:
        print(page['content'].strip().replace(" ", "").replace("\n\n","").split("\n")[index])

"""
[For Test] srcFile pdf파일을 begin page ~ end page 까지 잘라 targetFile에 저장한다
"""
def pdfSub(srcFile, targetFile, begin=0, end=1):
    pdfWriter = PyPDF2.PdfFileWriter()

    rf = open(srcFile, "rb")
    pdfReader = PyPDF2.PdfFileReader(rf)
    for page in range(begin, end, 1):
        pdfWriter.addPage(pdfReader.getPage(page))

    pdfWriter.addPage(pdfReader.getPage(page))

    wf = open(targetFile, 'wb')
    pdfWriter.write(wf)
    wf.close()
    rf.close()

def test():
    pdfSub('origin.pdf', 'tests/1.pdf', 0, 2)
    pdfSub('origin.pdf', 'tests/3.pdf', 17, 18)
    pdfSub('origin.pdf', 'tests/4.pdf', 23, 27) 
    pdfSub('origin.pdf', 'tests/5.pdf', 34, 36) 
    pdfSub('origin.pdf', 'tests/2.pdf', 4, 12) 

def main(directory):
    makeOnePdfFromDirectory2(directory, 'tmp.pdf')
    pages = parsePdf("tmp.pdf")
    sortedPageIndex = getSortedPageIndex(pages)
    for i, idx in enumerate(sortedPageIndex):
        print(str(i+1) + "p :", pages[idx]['category'])
    makeOrderdFile("tmp.pdf", directory + ".pdf", sortedPageIndex)

import argparse
argParser = argparse.ArgumentParser()
argParser.add_argument('-d', type=str)
args = argParser.parse_args()
print(args.d)
main(args.d)

#pages = parsePdf("test.pdf")
#showPage(pages[62])
