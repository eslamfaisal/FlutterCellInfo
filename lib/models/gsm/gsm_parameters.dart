import 'package:cell_info/models/common/cell_info.dart';

class GSMParameters extends BasicCellInfo {
  int cid;
  int lac;
  int bsic;
  int rssi;
  int bitErrorRate;
  int timingAdvance;

  GSMParameters({
    this.cid,
    this.lac,
    this.bsic,
    this.rssi,
    this.bitErrorRate,
    this.timingAdvance,
  });

  GSMParameters.fromJson(Map<String, dynamic> map) {
    this.cid = map['cid'];
    this.lac = map['lac'];
    this.bsic = map['bsic'];
    this.rssi = map['rssi'];
    this.bitErrorRate = map['bitErrorRate'];
    this.timingAdvance = map['timingAdvance'];

    Map<String, dynamic> toJson() {
      final Map<String, dynamic> data = new Map<String, dynamic>();
      data['cid'] = this.cid;
      data['lac'] = this.lac;
      data['bsic'] = this.bsic;
      data['rssi'] = this.rssi;
      data['bitErrorRate'] = this.bitErrorRate;
      data['timingAdvance'] = this.timingAdvance;
      return data;
    }
  }
}