from flask import Flask, render_template, request, jsonify
# from flask_restx import Api, Resource

app = Flask(__name__)
# api = Api(app)

# todos = {}
# count = 1

from pymongo import MongoClient
import certifi
ca = certifi.where()
client = MongoClient('mongodb+srv://sparta:test@atlascluster.pvc62zm.mongodb.net/?retryWrites=true&w=majority', tlsCAFile=ca)
db = client.dbsparta

import requests
from bs4 import BeautifulSoup

@app.route('/')
def home():
    return render_template('index.html')

@app.route("/team", methods=["POST"])
def team_post():
    image_receive = request.form['image_give']
    name_receive = request.form['name_give']
    mbti_receive = request.form['mbti_give']
    comment_receive = request.form['comment_give']
    sty_receive = request.form['sty_give']
    good_receive = request.form['good_give']
    url_receive = request.form['url_give']

    doc = {
        'image':image_receive,
        'name':name_receive,
        'mbti':mbti_receive,
        'comment':comment_receive,
        'sty':sty_receive,
        'good':good_receive,
        'url':url_receive
        }
    db.teams.insert_one(doc)

    return jsonify({'msg':'팀원 기록완료!'})

@app.route("/team", methods=["GET"])
def team_get():
    all_teams = list(db.teams.find({},{'_id':False}))
    return jsonify({'result':all_teams})

@app.route("/visit", methods=["POST"])
def visit_post():
    visit_receive = request.form['visit_give']
    vcom_receive = request.form['vcom_give']

    doc = {
        'visit':visit_receive,
        'vcom':vcom_receive
        }
    db.visitor.insert_one(doc)

    return jsonify({'msg':'방명록 저장완료!'})

@app.route("/visit", methods=["GET"])
def visit_get():
    all_visitors = list(db.visitor.find({},{'_id':False}))
    return jsonify({'result':all_visitors})

@app.route("/find", methods=["GET"])
def find_post():
    find_one = list(db.visitor.find_one({},{'_id':False}))
    return jsonify({'result':find_one})

# @app.route("/find", methods=["GET"])
# def find_post():
#     find_one = list(db.visitor.find_one({},{'_id':False}))
#     return jsonify({'result':find_one})

# @app.route("/edit", methods=["GET"])
# def edit_get():
#     vcom_list = list(db.visitor.find({},{'_id':False}))
#     return jsonify({'tests': vcom_list})

# def change_get():
#     find_db = list(db.teams.find({}))
#     return jsonify({msg: "수정완료"})

# @app.route("/open/edit", methods=["GET"])
# def edit_get():
#     edit_list = list(db.pythonthema.find({},{'_id':False}))
#     print(edit_list)

@app.route("/del", methods=["POST"])
def del_comment():
    delvisit_receive = request.form['delvisit_give']
    db.visitor.delete_one({'visit':delvisit_receive})
    
    return jsonify({'msg':'방명록 삭제완료!'})

if __name__ == '__main__':
    app.run('0.0.0.0', port=5000, debug=True)