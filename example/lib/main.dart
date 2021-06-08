import 'dart:async';
import 'dart:convert';
import 'package:cell_info/cell_info.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

import 'CellResponse.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  CellsResponse _cellsResponse;

  @override
  void initState() {
    super.initState();
    initPlatformState();
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    CellsResponse cellsResponse;
    // Platform messages may fail, so we use a try/catch PlatformException.
    try {
      String platformVersion = await CellInfo.getCellInfo;
      final body = json.decode(platformVersion);


      cellsResponse = CellsResponse.fromJson(body);
      print('primaryCellList.length ${cellsResponse.primaryCellList.length}');
      print('primaryCellList.length ${cellsResponse.neighboringCellList.length}');


    } on PlatformException {
      _cellsResponse = null;
    }

    // If the widget was removed from the tree while the asynchronous platform
    // message was in flight, we want to discard the reply rather than calling
    // setState to update our non-existent appearance.
    if (!mounted) return;

    setState(() {
      _cellsResponse = cellsResponse;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Text('Running on: $_cellsResponse\n'),
        ),
      ),
    );
  }
}
