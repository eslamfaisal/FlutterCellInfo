import 'package:cell_info/models/common/cell_info.dart';

class NrParameters extends BasicCellInfo {
  int nci;
  int tac;
  int pci;
  int csiRsrp;
  int csiRsrq;
  int csiSinr;
  int ssRsrp;
  int ssRsrq;
  int ssSinr;

  NrParameters({
    this.nci,
    this.tac,
    this.pci,
    this.csiRsrp,
    this.csiRsrq,
    this.csiSinr,
    this.ssRsrp,
    this.ssRsrq,
    this.ssSinr,
  });

  NrParameters.fromJson(Map<String, dynamic> map) {
    this.nci = map['nci'];
    this.tac = map['tac'];
    this.pci = map['pci'];
    this.csiRsrp = map['csiRsrp'];
    this.csiRsrq = map['csiRsrq'];
    this.csiSinr = map['csiSinr'];
    this.ssRsrp = map['ssRsrp'];
    this.ssRsrq = map['ssRsrq'];
    this.ssSinr = map['ssSinr'];

    Map<String, dynamic> toJson() {
      final Map<String, dynamic> data = new Map<String, dynamic>();
      data['nci'] = this.nci;
      data['tac'] = this.tac;
      data['pci'] = this.pci;
      data['csiRsrp'] = this.csiRsrp;
      data['csiRsrq'] = this.csiRsrq;
      data['csiSinr'] = this.csiSinr;
      data['ssRsrp'] = this.ssRsrp;
      data['ssRsrq'] = this.ssRsrq;
      data['ssSinr'] = this.ssSinr;
      return data;
    }
  }
}