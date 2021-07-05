import 'models/common/cell_type.dart';

class CellsResponse {
  List<CellType>? neighboringCellList;
  List<CellType>? primaryCellList;

  CellsResponse({this.neighboringCellList, this.primaryCellList});

  CellsResponse.fromJson(Map<String, dynamic> json) {
    if (json['neighboringCellList'] != null) {
      neighboringCellList = [];
      json['neighboringCellList'].forEach((v) {
        neighboringCellList!.add(new CellType.fromJson(v));
      });
    }
    if (json['primaryCellList'] != null) {
      primaryCellList = [];
      json['primaryCellList'].forEach((v) {
        primaryCellList!.add(new CellType.fromJson(v));
      });
    }
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.neighboringCellList != null) {
      data['neighboringCellList'] =
          this.neighboringCellList!.map((v) => v.toJson()).toList();
    }
    if (this.primaryCellList != null) {
      data['primaryCellList'] =
          this.primaryCellList!.map((v) => v.toJson()).toList();
    }
    return data;
  }
}